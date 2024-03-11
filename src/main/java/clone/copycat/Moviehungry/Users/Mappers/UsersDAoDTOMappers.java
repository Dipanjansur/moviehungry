package clone.copycat.Moviehungry.Users.Mappers;

import clone.copycat.Moviehungry.Users.DTOs.CreateUserDTO;
import clone.copycat.Moviehungry.Users.DTOs.SelfViewDTO;
import clone.copycat.Moviehungry.Users.DTOs.UserDTO;
import clone.copycat.Moviehungry.Users.UsersDAO;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Configuration;

@Configuration
@Mapper(componentModel = "spring")
public interface UsersDAoDTOMappers {
	public UserDTO UsersDAOTOUserDTO(UsersDAO usersdao);
	SelfViewDTO UsersDAOTOSeldViewSTO(UsersDAO users);
	UsersDAO CreateUSerDTOTOUSersDAO(CreateUserDTO usersdao);

}
