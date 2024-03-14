package clone.copycat.Moviehungry.Review;

import clone.copycat.Moviehungry.Movie.MovieDAO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reviews")
public class ReviewDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uuid;
    @NotBlank(message = "Movie ratings must not be null")
    @DecimalMin(value = "0.0", message = "Movie ratings must be at least 0.0")
    @DecimalMax(value = "10.0", message = "Movie ratings must not exceed 10.0")
    @NumberFormat(pattern = "##.#0")
    private double movieRatings;
    @ManyToOne
    @JoinColumn(name = "movies_uuid")
    @JsonIgnore
    private MovieDAO ratedMovie;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime creationTime;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedTime;
}
