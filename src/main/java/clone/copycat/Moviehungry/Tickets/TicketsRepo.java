package clone.copycat.Moviehungry.Tickets;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketsRepo extends JpaRepository<TicketsDAO, Long> {

    @Query(value = "select t.* from tickets t, showsseats shs,users u where u.userName=:username", nativeQuery = true)
    public List<TicketsDAO> findUsersByusername(String username);

    @Query(value = "select t.* from tickets t, showsseats shs,users u where u.uuid=:uuid", nativeQuery = true)

    public TicketsDAO booksSearchByUserId(Long uuid);
}
