package clone.copycat.Moviehungry.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UsersDAO,Long> {
	List<UsersDAO> findByRole(UserRoles role);
	List<UsersDAO> findByStatus(UserStatus status);
	Optional<UsersDAO>findByUserName(String username);
	Optional<UsersDAO>findByEmail(String email);

}
