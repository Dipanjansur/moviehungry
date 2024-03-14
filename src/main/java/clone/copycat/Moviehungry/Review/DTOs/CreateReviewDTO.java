package clone.copycat.Moviehungry.Review.DTOs;

import clone.copycat.Moviehungry.Movie.MovieDAO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CreateReviewDTO {
    @NotBlank(message = "Movie ratings must not be null")
    @DecimalMin(value = "0.0", message = "Movie ratings must be at least 0.0")
    @DecimalMax(value = "10.0", message = "Movie ratings must not exceed 10.0")
    @NumberFormat(pattern = "##.#0")
    private double movieRatings;
}
