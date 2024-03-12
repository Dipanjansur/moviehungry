package clone.copycat.Moviehungry.ShowSeats;

import clone.copycat.Moviehungry.Customexceptions.NosuchEntity;
import clone.copycat.Moviehungry.Show.Mapper.ShowMapper;
import clone.copycat.Moviehungry.Show.ShowDAO;
import clone.copycat.Moviehungry.Show.ShowsRepository;
import clone.copycat.Moviehungry.Show.ShowsService;
import clone.copycat.Moviehungry.ShowSeats.DTOs.ShowSeatsDTO;
import clone.copycat.Moviehungry.ShowSeats.Mappers.ShowSeatsMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowSeatsService {
    private ShowSeatsRepository showSeatsRepository;
    private ShowSeatsMapper showSeatsMapper;


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
        if(movie.get().getAvailable()==true){
            return  true;
        }else{
            return false;
        }
    }

}
