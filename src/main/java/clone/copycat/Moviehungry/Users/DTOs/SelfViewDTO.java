package clone.copycat.Moviehungry.Users.DTOs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SelfViewDTO {
    private Long uuid;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
}
