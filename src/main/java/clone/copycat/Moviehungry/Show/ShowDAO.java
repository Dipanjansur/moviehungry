package clone.copycat.Moviehungry.Show;

import clone.copycat.Moviehungry.Movie.MovieDAO;
import clone.copycat.Moviehungry.ShowSeats.ShowSeatsDAO;
import clone.copycat.Moviehungry.Theather.TheatersDAO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.NumberFormat;

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
    @JsonIgnore // Applied to avoid infinite recursion
    private List<ShowSeatsDAO> bookableSeats;
    @FutureOrPresent
    private LocalDateTime showTime;
    @Min(value = 1,message="the minimum value should be greater than 1")
    @Max(value =30000,message="the maximum value should be less than 30000")
    @NumberFormat(pattern = "##")
    private Long totalCapacity;
    @Min(value = 1,message="the minimum value should be greater than 1")
    @Max(value =30000,message="the maximum value should be less than 30000")
    @NumberFormat(pattern = "##")
    private Long filledCapacity;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime creationTime;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedTime;
}
