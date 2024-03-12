package clone.copycat.Moviehungry.Users;

import clone.copycat.Moviehungry.Customexceptions.IllegalArguments;
import clone.copycat.Moviehungry.Users.DTOs.CreateUserDTO;
import clone.copycat.Moviehungry.Users.DTOs.UserDTO;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {
    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getALlMembers() {
        return ResponseEntity.ok(usersService.getAllMembers());
    }

    @GetMapping("/userroles")
    public ResponseEntity<List<UserDTO>> getMemebersByRoles(@RequestParam UserRoles role) {
        return ResponseEntity.ok(usersService.getMemebersByRoles(role));
    }

    @GetMapping("/userstatus")
    public ResponseEntity<List<UserDTO>> getMemebersByStatus(@RequestParam UserStatus status) {
        return ResponseEntity.ok(usersService.getMemebersByStatus(status));

    }

    //@GetMapping("/membersId")
//    public ResponseEntity<Optional<UserDTO>> getMembersByUuid(@RequestParam(name ="userId") Long uuid) {
//        return ResponseEntity.ok(usersService.getMembersByUuid(uuid));
//
//    }
//
//    public ResponseEntity<Optional<UserDTO>> getMemberByUserName(String UserName) {
//        return ResponseEntity.ok(usersService.getMemberByUserName(UserName));
//
//    }
    @GetMapping("/search")
    public ResponseEntity<Optional<UserDTO>> getMembersByUserNameorPassword(@RequestParam(name = "userId", required = false) Long uuid, @RequestParam(name = "userName", required = false) String UserName) {
        if (UserName == null) {
            return ResponseEntity.ok(usersService.getMembersByUuid(uuid));
        } else if (uuid == null) {
            return ResponseEntity.ok(usersService.getMemberByUserName(UserName));
        } else {
            throw new IllegalArguments("please pass an valid argument");
        }
        // return ResponseEntity.ok(usersService.getMembersByUserNameorPassword(uuid, UserName));
    }

    @PostMapping("/")
    public ResponseEntity<Optional<UserDTO>> createMembers(CreateUserDTO newUsers) {
        return ResponseEntity.ok(usersService.createMembers(newUsers));
    }
}