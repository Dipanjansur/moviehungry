package clone.copycat.Moviehungry.Show;

import clone.copycat.Moviehungry.Movie.MovieDAO;
import clone.copycat.Moviehungry.Theather.TheathersDAO;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "shows")
public class ShowDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uuid;
    @ManyToOne
    @JoinColumn(name = "movies_uuid")
    private MovieDAO movie;
//    @ManyToMany(mappedBy ="showsDao")
//    private List<TheathersDAO> Theather;
    @ManyToMany(mappedBy = "runningShows")
    private List<MovieDAO> runnedMovie;
    private LocalDateTime showTime;
    private Long totalCapacity;
    private Long filledCapacity;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime creationTime;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedTime;
}
