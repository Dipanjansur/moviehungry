package clone.copycat.Moviehungry.Show;

import clone.copycat.Moviehungry.Customexceptions.NosuchEntity;
import clone.copycat.Moviehungry.Movie.MovieDAO;
import clone.copycat.Moviehungry.Movie.MovieRepository;
import clone.copycat.Moviehungry.Show.DTOs.CreateShowDTO;
import clone.copycat.Moviehungry.Show.DTOs.ShowDTO;
import clone.copycat.Moviehungry.Show.Mapper.ShowMapper;
import clone.copycat.Moviehungry.Theather.TheatersDAO;
import clone.copycat.Moviehungry.Theather.TheatersRepo;
import clone.copycat.Moviehungry.Theather.TheatersService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class ShowsService {
    private ShowsRepository showsRepository;
    private MovieRepository movieRepository;
    private ShowMapper showMapper;
    private TheatersRepo theatersRepo;

    @Autowired
    public ShowsService(ShowsRepository showsRepository, MovieRepository movieRepository, ShowMapper showMapper, TheatersRepo theatersRepo) {
        this.showsRepository = showsRepository;
        this.movieRepository = movieRepository;
        this.showMapper = showMapper;
        this.theatersRepo = theatersRepo;
    }
    public List<ShowDTO> findAllShows() {
        return showsRepository.findAll().stream().map(x -> showMapper.SHOWDAO_SHOWDTO(x)).collect(Collectors.toList());
    }

    public List<ShowDTO> findByMovieNameAndCity(Long movieId, String city) {
        System.out.println(movieId+"...."+city);
        return Optioncal_Mapper(() -> showsRepository.findByMovieNameAndCity(movieId, city));

    }

    public List<ShowDTO> findByCityname(String city) {
        System.out.println(city);
        return Optioncal_Mapper(() -> showsRepository.findByCityname(city));

    }

    public List<ShowDTO> findByTheaterAndCity(String theaterName, String cityName) {
        System.out.println(cityName+"...."+theaterName);
        return Optioncal_Mapper(() -> showsRepository.findByTheaterAndCity(theaterName, cityName));
    }
    public List<ShowDTO> findbyMoviesAndTheathers(Long movieId,String theatherName){
        return Optioncal_Mapper(() -> showsRepository.findbyMoviesAndTheathers(movieId, theatherName));
    }

    public List<ShowDTO> findByMovieNameAndCityAndTheather(Long movieId, String city, String theathername) {
        System.out.println(movieId+"...."+city+"...."+theathername);
        return Optioncal_Mapper(() -> showsRepository.findByMovieNameAndCityAndTheather(movieId, city, theathername));
    }

    private List<ShowDTO> Optioncal_Mapper(Supplier<List<ShowDAO>> supplier) {
        Supplier<List<ShowDAO>> retval = supplier;
        if (retval.get().isEmpty()) {
            throw new NosuchEntity("no shows is found nearby");
        } else {
            return retval.get().stream().map(
                    showMapper::SHOWDAO_SHOWDTO).collect(Collectors.toList());
        }
    }

    public ShowDTO addNewShow(CreateShowDTO showdao) {
        Optional<MovieDAO> retMovie = movieRepository.findById(Long.valueOf(showdao.getMovieId()));
        if (retMovie.isEmpty()) {
            throw new NosuchEntity("no such movies exists to add shows for it");
        }
        Optional<TheatersDAO> retTheather=theatersRepo.findById(showdao.getTheaterId());
        if (retMovie.isEmpty()) {
            throw new NosuchEntity("no such theathers  exists to add shows for it");
        }
        ShowDAO newShow = new ShowDAO().builder().movie(retMovie.get()).theaters(retTheather.get()).showTime(showdao.getShowTime()).build();
        //newShow.builder().movie(retMovie.get()).build();
        showsRepository.save(newShow);
        return showMapper.SHOWDAO_SHOWDTO(newShow);
    }

}
