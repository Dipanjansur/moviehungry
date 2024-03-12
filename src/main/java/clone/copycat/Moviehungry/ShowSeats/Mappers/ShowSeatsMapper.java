package clone.copycat.Moviehungry.ShowSeats.Mappers;

import clone.copycat.Moviehungry.ShowSeats.DTOs.BookinsSeatsDTO;
import clone.copycat.Moviehungry.ShowSeats.DTOs.CreateSeatsDTO;
import clone.copycat.Moviehungry.ShowSeats.DTOs.ShowSeatsDTO;
import clone.copycat.Moviehungry.ShowSeats.ShowSeatsDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel ="spring")
public interface ShowSeatsMapper {

    ShowSeatsDTO ShowSeatsDAO_ShowSeatsDTO(ShowSeatsDAO showSeatsDAO);
    @Mapping(target = "parentshow", ignore = true)

    BookinsSeatsDTO ShowSeatsDAO_BookinsSeatsDTO(ShowSeatsDAO showSeatsDAO);
    @Mapping(target = "parentshow", ignore = true)
    CreateSeatsDTO ShowSeatsDAO_CreateSeatsDTO(ShowSeatsDAO showSeatsDAO);
    ShowSeatsDAO ShowSeatsDTO_ShowSeatsDAO(ShowSeatsDTO showSeatsDTO);
    @Mapping(target = "parentshow", ignore = true)

    ShowSeatsDAO BookinsSeatsDTO_ShowSeatsDAO(BookinsSeatsDTO bookinsSeatsDTO);
    @Mapping(target = "parentshow", ignore = true)
    ShowSeatsDAO CreateSeatsDTO_ShowSeatsDAO(CreateSeatsDTO showSeatsDAO);

}
