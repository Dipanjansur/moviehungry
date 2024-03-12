package clone.copycat.Moviehungry.ShowSeats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShowSeatsRepository extends JpaRepository<ShowSeatsDAO,Long> {
    public Optional<ShowSeatsDAO> findBySeatNumber(String seatNumber);
}
