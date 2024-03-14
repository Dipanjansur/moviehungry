package clone.copycat.Moviehungry.Theather.DTOs;

import clone.copycat.Moviehungry.Show.DTOs.ShowDTO;
import clone.copycat.Moviehungry.Show.ShowDAO;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Getter
@Service
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddMoviesToTheathersDTO {
    @NotBlank
    private Long uuid;
    private List<ShowDTO> showDTOs;

}
