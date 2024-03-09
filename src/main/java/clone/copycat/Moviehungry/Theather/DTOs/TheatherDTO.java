package clone.copycat.Moviehungry.Theather.DTOs;

import clone.copycat.Moviehungry.Show.ShowDAO;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Getter
@Service
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheatherDTO {
    private Long uuid;
    private String name;
    private String cityname;
    private List<ShowDAO> showsDao;

}
