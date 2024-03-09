package clone.copycat.Moviehungry.Theather;

import clone.copycat.Moviehungry.Show.ShowDAO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "theaters")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TheatersDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uuid;
    private String name;
    // TOdo: use some partial data like postgis and see the oppertunity for it in hibernate
    private String cityname;
    @ManyToMany
    @JoinTable(name = "show_theatre", joinColumns = @JoinColumn(name = "theathers_uuid"), inverseJoinColumns = @JoinColumn(name = "shows_uuid"))
    private List<ShowDAO> showsDao;
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime creationTime;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedTime;
}
