package clone.copycat.Moviehungry.Users.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ChangePasswordDTO {
    private String OldPassword;
    private String NewPassword;
    private String ConfirmNewPassword;
}
