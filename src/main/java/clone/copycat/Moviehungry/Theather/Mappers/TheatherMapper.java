package clone.copycat.Moviehungry.Theather.Mappers;

import clone.copycat.Moviehungry.Theather.DTOs.AddMoviesToTheathersDTO;
import clone.copycat.Moviehungry.Theather.DTOs.AddTheatersDTO;
import clone.copycat.Moviehungry.Theather.DTOs.TheatherDTO;
import clone.copycat.Moviehungry.Theather.TheatersDAO;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring")
public interface TheatherMapper {
    TheatherDTO TheatherDAO_TheathersDTO(TheatersDAO theatersDAO);
    AddTheatersDTO TheatherDAO_AddTheatersDTO(TheatersDAO theatersDAO);
    AddMoviesToTheathersDTO TheatherDAO_AddMoviesToTheathersDTO(TheatersDAO theatersDAO);
    TheatersDAO TheatherDAO_TheatersDAO(TheatherDTO theatersDAO);
    TheatersDAO AddTheatersDTO_TheatersDAO(AddTheatersDTO addTheatersDTO);
    TheatersDAO AddMoviesToTheathersDTO_TheatersDAO(AddMoviesToTheathersDTO addMoviesToTheathersDTO);


}
