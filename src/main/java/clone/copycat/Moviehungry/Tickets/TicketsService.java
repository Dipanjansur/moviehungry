package clone.copycat.Moviehungry.Tickets;

import clone.copycat.Moviehungry.Customexceptions.ListedError;
import clone.copycat.Moviehungry.Customexceptions.NosuchEntity;
import clone.copycat.Moviehungry.Show.ShowDAO;
import clone.copycat.Moviehungry.ShowSeats.Mappers.ShowSeatsMapper;
import clone.copycat.Moviehungry.ShowSeats.ShowSeatsDAO;
import clone.copycat.Moviehungry.ShowSeats.ShowSeatsRepository;
import clone.copycat.Moviehungry.Tickets.DTOs.TicketBookingDTO;
import clone.copycat.Moviehungry.Tickets.DTOs.TicketsDTO;
import clone.copycat.Moviehungry.Tickets.Mappers.TicketsMapper;
import clone.copycat.Moviehungry.Users.UsersDAO;
import clone.copycat.Moviehungry.Users.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.image.ImageProducer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketsService {
    private TicketsRepo ticketsRepo;
    private ShowSeatsRepository showSeatsRepository;
    private UsersRepository usersRepository;
    private TicketsMapper mapper;

    @Autowired
    public TicketsService(TicketsRepo ticketsRepo, ShowSeatsRepository showSeatsRepository, UsersRepository usersRepository, TicketsMapper mapper) {
        this.ticketsRepo = ticketsRepo;
        this.showSeatsRepository = showSeatsRepository;
        this.usersRepository = usersRepository;
        this.mapper = mapper;
    }

    public List<TicketsDTO> booksSearchByUser(String username) {
        List<TicketsDAO> retickets = ticketsRepo.findUsersByusername(username);
        if (retickets == null) {
            throw new NosuchEntity("no suck tickets are booked by this user");
        } else {
            return retickets.stream().map(mapper::TicketsDAO_TicketsDTO).collect(Collectors.toList());
        }
    }

    public TicketsDTO booksSearchByUserId(Long uuid) {
        TicketsDAO retickets = ticketsRepo.booksSearchByUserId(uuid);
        if (retickets == null) {
            throw new NosuchEntity("no suck tickets are booked by this user");
        } else {
            return mapper.TicketsDAO_TicketsDTO(retickets);
        }
    }

    @Transactional
    public TicketsDTO bookTicket(TicketBookingDTO ticketBookingDTO) {
        // ListedError errorlist=new ListedError();
        List<ShowSeatsDAO> validSeats = ticketBookingDTO.getSeatIds().stream()
                .map(showSeatsRepository::findBySeatNumber)
                .filter(Optional::isPresent) // Filter out empty Optionals
                .map(Optional::get) // Extract ShowSeatsDAO objects from Optionals
                .collect(Collectors.toList());
        Optional<UsersDAO> usersDAO = usersRepository.findById(ticketBookingDTO.getId());
        TicketsDAO ticketsDAO = TicketsDAO.builder().seat(validSeats).bookedBy(usersDAO.get()).build();
        TicketsDAO savedTicket = ticketsRepo.save(ticketsDAO);
        validSeats.stream().forEach(x -> {
            x.setAvailable(false);
            showSeatsRepository.save(x);
        });
        return mapper.TicketsDAO_TicketsDTO(savedTicket);
    }

//    public ResponseEntity<Object> cancelTicket(Long uuid) {
//
//    }
}
