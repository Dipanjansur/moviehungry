package clone.copycat.Moviehungry.Show;

import clone.copycat.Moviehungry.Show.DTOs.ShowDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowsRepository extends JpaRepository<ShowDAO, Long> {
    @Query(value = "select s.* from shows s,movies m,theaters th where m.uuid=s.movies.uuid and s.theaters_uuid=th.uuid and m.name=:movieId and th.cityname=:city", nativeQuery = true)
    public List<ShowDAO> findByMovieNameAndCity(Long movieId, String city);

    @Query(value = "select s.*,th.name from shows s, theaters th where th.cityname = :cityname", nativeQuery = true)
    public List<ShowDAO> findByCityname(String cityname);

    @Query(value = "select s.* from shows s,movies m,theaters th where th.name=:theaterName and th.cityname=:cityName", nativeQuery = true)
    public List<ShowDAO> findByTheaterAndCity(String theaterName, String cityName);

    @Query(value = "select s.* from shows s,movies m,theaters th where m.uuid=:movieId and th.name=:theatherName", nativeQuery = true)
    public List<ShowDAO> findbyMoviesAndTheathers(Long movieId,String theatherName);
    @Query(value = "select s.* from shows s,movies m,theaters th where s.theaters_uuid=th.uuid and m.name=:movieId and th.cityname=:city and th.name=:theathername", nativeQuery = true)
    public List<ShowDAO>findByMovieNameAndCityAndTheather(Long movieId, String city, String theathername);

    @Query(value = "select s.* from shows s,movies m,theaters th where s.theaters_uuid=th.uuid and m.name=:theathername and th.name=:city", nativeQuery = true)
    public List<ShowDAO> findByTheatherAndCity(String theathername, String city);
}
