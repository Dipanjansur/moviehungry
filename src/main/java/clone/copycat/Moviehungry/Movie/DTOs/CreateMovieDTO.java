package clone.copycat.Moviehungry.Movie.DTOs;

import clone.copycat.Moviehungry.Movie.Genre;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CreateMovieDTO {
    private String name;
    private LocalDate releaseyear;
    private long uniqueId;
    private Genre movieGenre;
}
