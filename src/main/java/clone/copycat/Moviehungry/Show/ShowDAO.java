package clone.copycat.Moviehungry.Show;

import clone.copycat.Moviehungry.Movie.MovieDAO;
import clone.copycat.Moviehungry.ShowSeats.ShowSeatsDAO;
import clone.copycat.Moviehungry.Theather.TheatersDAO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "shows")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uuid;
    @ManyToOne
    @JoinColumn(name = "movies_uuid")
    private MovieDAO movie;
    @ManyToOne
    @JoinColumn(name = "theatres_uuid")
    private TheatersDAO theaters;
    @OneToMany(mappedBy ="parentshow")
    private List<ShowSeatsDAO> bookableSeats;
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
