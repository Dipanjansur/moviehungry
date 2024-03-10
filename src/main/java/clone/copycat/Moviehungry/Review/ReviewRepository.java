package clone.copycat.Moviehungry.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<ReviewDAO,Long> {
    @Query(value = "select * from reviews where movies_uuid=?",nativeQuery = true )
    List<ReviewDAO> findByReviewratedMovie(Long uuid);
}
