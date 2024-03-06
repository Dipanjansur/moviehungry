package clone.copycat.Moviehungry.Review.DTOs;

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
    private  long uuid;
//    private long numberOfreview;
//    private double totalRating;
    private double movieRatings;
    private MovieDAO ratedMovie;
}
