package clone.copycat.Moviehungry.Movie;

import clone.copycat.Moviehungry.Review.ReviewDAO;
import clone.copycat.Moviehungry.Show.ShowDAO;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies",indexes = @Index(columnList = "uniqueId"))
public class MovieDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uuid;
    @Size(min = 1,max=50,message="please provide a movie length the should be greater than 1 and less than 50")
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
    @OneToMany(fetch =FetchType.LAZY,mappedBy = "movie")
    private List<ShowDAO> runningShows;
    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime creationTime;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedTime;
    @AssertTrue(message = "Release year must be after 1990")
    public boolean setreleaseYear() {
        return releaseyear == null || releaseyear.isAfter(LocalDate.of(1990, 12, 31));
    }
}
