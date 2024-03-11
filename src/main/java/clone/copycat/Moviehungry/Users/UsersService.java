package clone.copycat.Moviehungry.Users;

import clone.copycat.Moviehungry.Customexceptions.DouplicateEntity;
import clone.copycat.Moviehungry.Customexceptions.NosuchEntity;
import clone.copycat.Moviehungry.Users.DTOs.CreateUserDTO;
import clone.copycat.Moviehungry.Users.DTOs.UserDTO;
import clone.copycat.Moviehungry.Users.Mappers.UsersDAoDTOMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService {
    private UsersRepository usersRepository;
    private UsersDAoDTOMappers usersDAoDTOMappers;

    @Autowired
    public UsersService(UsersRepository usersRepository, UsersDAoDTOMappers usersDAOtoDTO) {
        this.usersRepository = usersRepository;
        this.usersDAoDTOMappers = usersDAOtoDTO;
    }
    List<UserDTO> getAllMembers() {
        return  usersRepository.findAll().stream().map(usersDAoDTOMappers::UsersDAOTOUserDTO).collect(Collectors.toList());
    }
    List<UserDTO> getMemebersByRoles(UserRoles role) {
        List<UsersDAO> retrivedUser = usersRepository.findByRole(role);
        if (retrivedUser.isEmpty()) {
            throw new NosuchEntity("No such member exists",
                    "please visit to /signup to create a valid userAccout and enjoy our Service");
        }
        return retrivedUser.stream().map(usersDAoDTOMappers::UsersDAOTOUserDTO).collect(Collectors.toList());
    }
    List<UserDTO> getMemebersByStatus(UserStatus status) {
        List<UsersDAO> retrivedUser = usersRepository.findByStatus(status);
        if (retrivedUser.isEmpty()) {
            throw new NosuchEntity("No such member exists",
                    "please visit to /signup to create a valid userAccout and enjoy our Service");
        }
        return retrivedUser.stream().map(usersDAoDTOMappers::UsersDAOTOUserDTO).collect(Collectors.toList());
    }

    Optional<UserDTO> getMembersByUuid(Long uuid) {
        Optional<UsersDAO> userById = usersRepository.findById(uuid);
        if (userById.isEmpty()) {
            throw new NosuchEntity("no such user is availble with that Name", "please create a user or pass a valid Id");
        }
        return Optional.ofNullable(usersDAoDTOMappers.UsersDAOTOUserDTO(userById.get()));
    }

    Optional<UserDTO> getMemberByUserName(String UserName) {
        Optional<UsersDAO> usesByUsername = usersRepository.findByUserName(UserName);
        if (usesByUsername.isEmpty()) {
            throw new NosuchEntity("no such user is availble with that UserName",
                    "please create a user or pass a valid username");
        }
        return Optional.ofNullable(usersDAoDTOMappers.UsersDAOTOUserDTO(usesByUsername.get()));
    }

//    Optional<UserDTO> getMembersByUserNameorPassword(Optional<Long> uuid, Optional<String> UserName){
//        UsersDAO newuser = new UsersDAO();
//        Optional<UsersDAO> tempUser = Optional.of(null);
//        if (uuid.isPresent()) {
//            tempUser = usersRepository.findById(uuid.get());
//        } else if (UserName.isPresent()) {
//            tempUser = usersRepository.findByUserName(UserName.get());
//        }
//        if (tempUser.isEmpty()) {
//            throw new NosuchEntity("no such user is present with this username", "please create a account at /signup");
//        }
//        return Optional.ofNullable(usersDAoDTOMappers.UsersDAOTOUserDTO(tempUser.get()));
//    }

    Optional<UserDTO> createMembers(CreateUserDTO newUsers) {
        UsersDAO createNewUser = usersDAoDTOMappers.CreateUSerDTOTOUSersDAO(newUsers);
        Optional<UsersDAO> ifUsersExistsByEmail = usersRepository.findByEmail(newUsers.getEmail());
        Optional<UsersDAO> ifUsersExistsByUserName = usersRepository.findByUserName(newUsers.getUserName());
        if (ifUsersExistsByUserName.isPresent() || ifUsersExistsByEmail.isPresent()) {
            throw new DouplicateEntity("Username or Email is already present",
                    "please create a user a valid username or email");
        }
        createNewUser.setRole(UserRoles.USER);
        UsersDAO savedUser = usersRepository.save(createNewUser);
        return Optional.ofNullable(usersDAoDTOMappers.UsersDAOTOUserDTO(savedUser));
    }

    // TODO: crete a BookDTO and change it

}
