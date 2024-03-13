package clone.copycat.Moviehungry.Movie;

import clone.copycat.Moviehungry.Review.ReviewDAO;
import clone.copycat.Moviehungry.Show.ShowDAO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.actuate.endpoint.Show;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
public class MovieDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uuid;
    private String name;
    @Column(unique = true)
    private Long uniqueId;
    private LocalDate releaseyear;
    @Enumerated(EnumType.STRING)
    private Genre movieGenre;
    private Long numberofReviews;
    private Double movieRating;
    @OneToMany(fetch =FetchType.LAZY,mappedBy = "ratedMovie")
    private Set<ReviewDAO> movieReviews;
    @OneToMany(mappedBy = "movie")
    private List<ShowDAO> runningShows;
    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime creationTime;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedTime;
}
