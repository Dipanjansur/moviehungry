package clone.copycat.Moviehungry.Review;

import clone.copycat.Moviehungry.Movie.MovieDAO;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="reviews")
public class ReviewDAO {
    @Id
    @GeneratedValue
    private  long uuid;
    private long numberOfreview;
    private double movieRatings;
    @ManyToOne
    @JoinColumn(name = "movies_uuid")
    private MovieDAO ratedMovie;
    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime creationTime;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedTime;
}
