package clone.copycat.Moviehungry.Review.DTOs;

import clone.copycat.Moviehungry.Movie.DTOs.MovieDTO;
import clone.copycat.Moviehungry.Movie.MovieDAO;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ReviewDTO {
    private Long uuid;
    private double movieRatings;
    private Long movieId;
    private String movieName;
}
