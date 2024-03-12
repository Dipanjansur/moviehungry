package clone.copycat.Moviehungry.Tickets;

import clone.copycat.Moviehungry.ShowSeats.ShowSeatsDAO;
import clone.copycat.Moviehungry.Users.UserRoles;
import clone.copycat.Moviehungry.Users.UsersDAO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "tickets")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketsDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;
    @OneToMany(mappedBy ="tickets")
    private List<ShowSeatsDAO> seat;
    @ManyToOne
    @JoinColumn(name="users_id")
    private UsersDAO bookedBy;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime creationTime;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedTime;
}
