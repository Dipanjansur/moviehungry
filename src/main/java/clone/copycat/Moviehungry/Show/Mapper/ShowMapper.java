package clone.copycat.Moviehungry.Show.Mapper;

import clone.copycat.Moviehungry.Show.DTOs.CreateShowDTO;
import clone.copycat.Moviehungry.Show.DTOs.ShowDTO;
import clone.copycat.Moviehungry.Show.ShowDAO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShowMapper {
    ShowDTO SHOWDAO_SHOWDTO(ShowDAO showDAO);
    CreateShowDTO SHOWDAO_CreateShowDTO(ShowDAO showDAO);
    ShowDAO ShowDTO_ShowDAO(ShowDTO showDTO);
    ShowDAO CreateShowDTO_ShowDAO(CreateShowDTO createShowDTO);
}
