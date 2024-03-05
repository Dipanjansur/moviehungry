package clone.copycat.Moviehungry.Movie.DTOs;

import clone.copycat.Moviehungry.Movie.Genre;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovieDTO {
    private String name;
    private LocalDate releaseyear;
    private long uniqueId;
    private Genre movieGenre;
}
