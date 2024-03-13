package clone.copycat.Moviehungry.Movie.DTOs;

import clone.copycat.Moviehungry.Movie.Genre;
import clone.copycat.Moviehungry.Review.DTOs.ReviewDTO;
import clone.copycat.Moviehungry.Review.ReviewDAO;
import clone.copycat.Moviehungry.Show.DTOs.ShowDTO;
import clone.copycat.Moviehungry.Show.ShowDAO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MovieDTO {
    private Long uuid;
    private String name;
    private LocalDate releaseyear;
    private Genre movieGenre;
    private Long numberofReviews;
    private Long movieRating;
    private Set<ReviewDTO> movieReviews;
    private List<ShowDTO> runningShows;
}
// TODO: follow the proper mapping add lot of validation change DAOs to DTOs and thenchange some
// TODO: add more validation limit what is allowed
// TODO: change some fieldds name to hide the DAO name of the database
// TODO: Add some @BeforeValidation to check the length of the movie and the running shows