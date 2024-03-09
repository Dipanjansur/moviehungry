package clone.copycat.Moviehungry.Theather.DTOs;

import clone.copycat.Moviehungry.Show.ShowDAO;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Getter
@Service
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddMoviesToTheathersDTO {
    private Long uuid;
    private List<ShowDAO> showsDao;
}
