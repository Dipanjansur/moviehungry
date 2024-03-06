package clone.copycat.Moviehungry.Show;

import clone.copycat.Moviehungry.Customexceptions.NosuchEntity;
import clone.copycat.Moviehungry.Movie.MovieDAO;
import clone.copycat.Moviehungry.Movie.MovieRepository;
import clone.copycat.Moviehungry.Show.DTOs.CreateShowDTO;
import clone.copycat.Moviehungry.Show.DTOs.ShowDTO;
import clone.copycat.Moviehungry.Show.Mapper.ShowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class ShowsService {
    private ShowsRepository showsRepository;
    private MovieRepository movieRepository;
    private ShowMapper showMapper;

    @Autowired
    public ShowsService(ShowsRepository showsRepository, MovieRepository movieRepository, ShowMapper showMapper) {
        this.showsRepository = showsRepository;
        this.movieRepository = movieRepository;
        this.showMapper = showMapper;
    }

    public Optional<List<ShowDTO>> findByMovieNameAndCity(Long movieId, String city) {
        return Optioncal_Mapper(() -> showsRepository.findByMovieNameAndCity(movieId, city));

    }

    public Optional<List<ShowDTO>> findByTheatherAndCity(String name, String city) {
        return Optioncal_Mapper(() -> showsRepository.findByTheatherAndCity(name, city));

    }

    public Optional<List<ShowDTO>> findByCityname(String city) {
        return Optioncal_Mapper(() -> showsRepository.findByCityname(city));

    }

    public Optional<List<ShowDTO>> findByTheaterAndCity(String theaterName, String cityName) {
        return Optioncal_Mapper(() -> showsRepository.findByTheaterAndCity(theaterName, cityName));
    }

    public Optional<List<ShowDTO>> findByMovieNameAndCityAndTheather(Long movieId, String city, String theathername) {
        return Optioncal_Mapper(() -> showsRepository.findByMovieNameAndCityAndTheather(movieId, city, theathername));
    }

    private Optional<List<ShowDTO>> Optioncal_Mapper(Supplier<Optional<List<ShowDAO>>> supplier) {
        Optional<List<ShowDAO>> retval = supplier.get();
        if (retval.isEmpty()) {
            throw new NosuchEntity("no shows is found nearby");
        } else {
            return Optional.of(retval.get().stream().map(showMapper::SHOWDAO_SHOWDTO).collect(Collectors.toList()));
        }
    }

    public Optional<ShowDTO> addNewShow(CreateShowDTO showdao) {
        Optional<MovieDAO> retMovie = movieRepository.findById(Long.valueOf(showdao.getMovieId()));
        if (retMovie.isEmpty()) {
            throw new NosuchEntity("no such movies exists to rate it");
        }
        ShowDAO newShow=showMapper.CreateShowDTO_ShowDAO(showdao);
        newShow.builder().movie(retMovie.get()).build();
        showsRepository.save(newShow);
        return Optional.ofNullable(showMapper.SHOWDAO_SHOWDTO(newShow));
    }

}
