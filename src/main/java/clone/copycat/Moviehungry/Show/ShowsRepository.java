package clone.copycat.Moviehungry.Show;

import clone.copycat.Moviehungry.Show.DTOs.ShowDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowsRepository extends JpaRepository<ShowDAO, Long> {
    @Query(value = "select * from shows s,movies m,theaters th where m.uuid=s.runnedMovie_uuid and s.theaters_uuid=th.uuid and m.name=? and th.cityname=?", nativeQuery = true)
    public Optional<List<ShowDAO>> findByMovieNameAndCity(Long movieId, String city);

    @Query(value = "select * from shows s,theaters th where s.theaters_uuid=th.uuid and s.theaters_cityname=?", nativeQuery = true)
    public Optional<List<ShowDAO>> findByCityname(String city);

    @Query(value = "select * from shows s,movies m,theaters th where m.uuid=s.runnedMovie_uuid and s.theaters_uuid=th.uuid and th.name=? and th.cityname=?", nativeQuery = true)
    Optional<List<ShowDAO>> findByTheaterAndCity(String theaterName, String cityName);

    @Query(value = "select * from shows s,movies m,theaters th where m.uuid=s.runnedMovie_uuid and s.theaters_uuid=th.uuid and m.name=? and th.cityname=? and th.name=?", nativeQuery = true)
    public Optional<List<ShowDAO>> findByMovieNameAndCityAndTheather(Long movieId, String city, String theathername);

    @Query(value = "select * from shows s,movies m,theaters th where m.uuid=s.runnedMovie_uuid and s.theaters_uuid=th.uuid and m.name=? and th.name=?", nativeQuery = true)
    public Optional<List<ShowDAO>> findByTheatherAndCity(String  theathername, String city);
    }
