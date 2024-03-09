package clone.copycat.Moviehungry.Theather;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TheatersRepo extends JpaRepository<TheatersDAO, Long> {
    public List<TheatersDAO>findByCityname(String cityName);
    public List<TheatersDAO> findByName(String Name);
}
