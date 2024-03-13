package clone.copycat.Moviehungry.Show.DTOs;

import clone.copycat.Moviehungry.Movie.DTOs.MovieDTO;
import clone.copycat.Moviehungry.Movie.MovieDAO;
import clone.copycat.Moviehungry.Theather.DTOs.AddTheatersDTO;
import clone.copycat.Moviehungry.Theather.DTOs.TheatherDTO;
import clone.copycat.Moviehungry.Theather.TheatersDAO;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShowDTO {
    private Long uuid;
    private Long movieId;
    private String movieName;
    private Long theatherId;
    private String theatherName;
    private LocalDateTime showTime;
    private Long totalCapacity;
    private Long filledCapacity;
}
