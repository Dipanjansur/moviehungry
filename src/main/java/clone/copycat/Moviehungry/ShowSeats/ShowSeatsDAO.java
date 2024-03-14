package clone.copycat.Moviehungry.ShowSeats;

import clone.copycat.Moviehungry.Show.ShowDAO;
import clone.copycat.Moviehungry.Tickets.TicketsDAO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.NumberFormat;

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
    @NumberFormat(pattern ="##")
    @Size(max = 2, message = "Seat number must not exceed 2 characters")
    private String seatNumber;
    @Min(value = 1, message = "Row number must be at least 1")
    private Integer rowNum;
    @Min(value = 'A', message = "Column number must be bigger than A")
    private String columnNum;
    @NotBlank
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
