package clone.copycat.Moviehungry.Users.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
}
