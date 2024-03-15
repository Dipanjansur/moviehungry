package clone.copycat.Moviehungry.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<MovieDAO,Long> {
    public Optional<MovieDAO> findByUniqueId(long uniqueId);
    public Optional<List<MovieDAO>> findByName(String name);
    public Optional<List<MovieDAO>> findByGenre(String genre);

}
