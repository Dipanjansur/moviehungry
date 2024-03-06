package clone.copycat.Moviehungry.Movie.DTOs;

import clone.copycat.Moviehungry.Movie.Genre;
import clone.copycat.Moviehungry.Review.ReviewDAO;
import clone.copycat.Moviehungry.Show.ShowDAO;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDTO {
    private Long uuid;
    private String name;
    private LocalDate releaseyear;
    private Genre movieGenre;
    private Long movieRating;

    private Set<ReviewDAO> movieReviews;

    private List<ShowDAO> runningShows;
}
