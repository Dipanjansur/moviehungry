package clone.copycat.Moviehungry.ShowSeats;

import clone.copycat.Moviehungry.Customexceptions.NosuchEntity;
import clone.copycat.Moviehungry.Movie.MovieDAO;
import clone.copycat.Moviehungry.Show.Mapper.ShowMapper;
import clone.copycat.Moviehungry.Show.ShowDAO;
import clone.copycat.Moviehungry.Show.ShowsRepository;
import clone.copycat.Moviehungry.Show.ShowsService;
import clone.copycat.Moviehungry.ShowSeats.DTOs.BookinsSeatsDTO;
import clone.copycat.Moviehungry.ShowSeats.DTOs.CreateSeatsDTO;
import clone.copycat.Moviehungry.ShowSeats.DTOs.ShowSeatsDTO;
import clone.copycat.Moviehungry.ShowSeats.Mappers.ShowSeatsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowSeatsService {
    private ShowSeatsRepository showSeatsRepository;
    private ShowsRepository showsRepository;
    private ShowSeatsMapper showSeatsMapper;

    @Autowired
    public ShowSeatsService(ShowSeatsRepository showSeatsRepository, ShowsRepository showsRepository, ShowSeatsMapper showSeatsMapper) {
        this.showSeatsRepository = showSeatsRepository;
        this.showsRepository = showsRepository;
        this.showSeatsMapper = showSeatsMapper;
    }

    public ShowSeatsDTO getSetsByUUid(Long uuid) {
        Optional<ShowSeatsDAO> movie = showSeatsRepository.findById(uuid);
        if (movie.isEmpty()) {
            throw new NosuchEntity("no such seats exits by this Id");
        } else {
            return showSeatsMapper.ShowSeatsDAO_ShowSeatsDTO(movie.get());
        }
    }

    public ShowSeatsDTO getSeatsByseatNumber(String seatNumber) {
        Optional<ShowSeatsDAO> movie = showSeatsRepository.findBySeatNumber(seatNumber);
        if (movie.isEmpty()) {
            throw new NosuchEntity("no such seats exits by this seatnumber");
        } else {
            return showSeatsMapper.ShowSeatsDAO_ShowSeatsDTO(movie.get());
        }
    }

    public boolean checkAvaible(Long uuid) {
        Optional<ShowSeatsDAO> movie = showSeatsRepository.findById(uuid);
        if (movie.isEmpty()) {
            throw new NosuchEntity("no such seats exits by this Id");
        }
        if (movie.get().getAvailable() == true) {
            return true;
        } else {
            return false;
        }
    }

    public ShowSeatsDTO createSeat(CreateSeatsDTO showSeatsDTO) {
        ShowSeatsDAO createseat = showSeatsMapper.CreateSeatsDTO_ShowSeatsDAO(showSeatsDTO);
        Optional<ShowDAO> showDAO = showsRepository.findById(Long.valueOf(showSeatsDTO.getParentshow()));
        if (showDAO.isEmpty()) {
            throw new NosuchEntity("so such movie exits");
        }
        createseat.setParentshow(showDAO.get());
        showSeatsRepository.save(createseat);
        return showSeatsMapper.ShowSeatsDAO_ShowSeatsDTO(createseat);
    }

}
