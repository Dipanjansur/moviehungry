package clone.copycat.Moviehungry.Show.Mapper;

import clone.copycat.Moviehungry.Show.DTOs.CreateShowDTO;
import clone.copycat.Moviehungry.Show.DTOs.ShowDTO;
import clone.copycat.Moviehungry.Show.ShowDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ShowMapper {
    @Mapping(source ="movie.uuid" ,target="movieId" )
    @Mapping(source ="movie.name",target="movieName" )
    @Mapping(source ="theaters.uuid" ,target="theatherId" )
    @Mapping(source ="theaters.name",target="theatherName" )
    ShowDTO SHOWDAO_SHOWDTO(ShowDAO showDAO);
    CreateShowDTO SHOWDAO_CreateShowDTO(ShowDAO showDAO);
    @Mapping(source ="movieId",target="movie.uuid" )
    @Mapping(source ="movieName",target="movie.name" )
    @Mapping(source ="theatherId",target="theaters.uuid" )
    @Mapping(source ="theatherName",target="theaters.name" )
    ShowDAO ShowDTO_ShowDAO(ShowDTO showDTO);
    ShowDAO CreateShowDTO_ShowDAO(CreateShowDTO createShowDTO);
}
