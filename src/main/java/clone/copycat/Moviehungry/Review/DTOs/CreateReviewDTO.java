package clone.copycat.Moviehungry.Review.DTOs;

import clone.copycat.Moviehungry.Movie.MovieDAO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CreateReviewDTO {
    private double movieRatings;
}
