package clone.copycat.Moviehungry.ShowSeats;

import clone.copycat.Moviehungry.Show.ShowDAO;
import clone.copycat.Moviehungry.Tickets.TicketsDAO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDateTime;

@Entity
@Table(name = "showsseats")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeatsDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;
    @ManyToOne
    @JoinColumn(name = "shows_parent")
    private ShowDAO parentshow;
    @Column(unique=true)
    private String seatNumber;
    private Integer rowNum;
    private String columnNum;
    private Boolean available;
    @ManyToOne
    @JoinColumn(name = "tickets_uuid")
    private TicketsDAO tickets;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime creationTime;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedTime;
}
