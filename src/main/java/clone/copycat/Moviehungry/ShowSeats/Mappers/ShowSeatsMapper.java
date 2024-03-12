package clone.copycat.Moviehungry.ShowSeats.Mappers;

import clone.copycat.Moviehungry.ShowSeats.DTOs.BookinsSeatsDTO;
import clone.copycat.Moviehungry.ShowSeats.DTOs.ShowSeatsDTO;
import clone.copycat.Moviehungry.ShowSeats.ShowSeatsDAO;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface ShowSeatsMapper {
    ShowSeatsDTO ShowSeatsDAO_ShowSeatsDTO(ShowSeatsDAO showSeatsDAO);
    BookinsSeatsDTO ShowSeatsDAO_BookinsSeatsDTO(ShowSeatsDAO showSeatsDAO);
    ShowSeatsDAO ShowSeatsDTO_ShowSeatsDAO(ShowSeatsDTO showSeatsDTO);
    ShowSeatsDAO BookinsSeatsDTO_ShowSeatsDAO(BookinsSeatsDTO bookinsSeatsDTO);


}
