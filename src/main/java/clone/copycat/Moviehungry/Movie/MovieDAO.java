package clone.copycat.Moviehungry.Movie;

import clone.copycat.Moviehungry.Review.ReviewDAO;
import clone.copycat.Moviehungry.Show.ShowDAO;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.actuate.endpoint.Show;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movies")
public class MovieDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uuid;
    private String name;
    private LocalDate releaseyear;
    private Genre movieGenre;
    private Long movieRating;
    @OneToMany
    @JoinColumn(name = "reviews_uuid")
    private Set<ReviewDAO> movieReviews;
    @ManyToMany
    @JoinTable( name = "course_like", joinColumns =@JoinColumn(name = "reviews_uuid"),inverseJoinColumns =@JoinColumn(name = "movies_uuid"))
    private List<ShowDAO> runningShows;
    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime creationTime;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedTime;
}
