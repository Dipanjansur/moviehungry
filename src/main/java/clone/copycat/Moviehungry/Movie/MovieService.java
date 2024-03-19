package clone.copycat.Moviehungry.Movie;

import clone.copycat.Moviehungry.Customexceptions.IllegalArguments;
import clone.copycat.Moviehungry.Customexceptions.NosuchEntity;
import clone.copycat.Moviehungry.Movie.DTOs.CreateMovieDTO;
import clone.copycat.Moviehungry.Movie.DTOs.MovieDTO;
import clone.copycat.Moviehungry.Users.UsersDAO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class MovieService {
    private static final Logger LOG = LoggerFactory.getLogger(MovieService.class);
    private MovieRepository movieRepository;
    private MapperMovie mapperMovie;

    @Autowired
    public MovieService(MovieRepository movieRepository, MapperMovie mapperMovie) {
        this.movieRepository = movieRepository;
        this.mapperMovie = mapperMovie;
    }

    public List<MovieDTO> getAllMovies() {
        List<MovieDAO> allMovies = movieRepository.findAll();
        return allMovies.stream().map(x ->{
//           x.getMovieReviews().stream().map(x->)
             return mapperMovie.MovieDAO_MovieDTO(x);}).collect(Collectors.toList());
    }

    public MovieDTO addMovie(CreateMovieDTO createMovieDTO) {
        Optional<MovieDAO> ifMovieExits = movieRepository.findByUniqueId(createMovieDTO.getUniqueId());
        if (ifMovieExits.isPresent()) {
            throw new NosuchEntity("A movie is already preasent with the same Id");
        } else {
            try {
                MovieDAO transformed = mapperMovie.MovieDAO_CreateMovieDTO(createMovieDTO);
                transformed.setMovieRating(0.0);
                transformed.setNumberofReviews(0l);
                movieRepository.save(transformed);
                return mapperMovie.MovieDAO_MovieDTO(transformed);
            } catch (IllegalArgumentException ex) {
                LOG.error(ex.getMessage(), ex);
                throw new IllegalArguments(ex.getMessage());
            } catch (OptimisticLockingFailureException ex) {
                LOG.error(ex.getMessage(), ex);
                throw new OptimisticLockingFailureException("something is wrong cant save movie");
            }
        }
    }

    public MovieDTO findMovieByidOruuid(Long id, Long uuid) {
        Optional<MovieDAO> founduser;
        try {
            if (id != null) {
                founduser = movieRepository.findById(id);
            } else if (uuid != null) {
                founduser = movieRepository.findByUniqueId(uuid);
            } else {
                throw new IllegalArguments("please pass in a valid uuid or Id to continue");
            }
            if (founduser.isEmpty()) {
                throw new NosuchEntity("No such user is present in the platform");
            }
            return mapperMovie.MovieDAO_MovieDTO(founduser.get());
        } catch (IllegalArgumentException ex) {
            LOG.error(ex.getMessage(), ex);
            throw new IllegalArguments("Please pass in a valid uuid or Id to continue");
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException("something is wrong with the server");
        }
    }

    public List<MovieDTO> findMovieByTittle(String tittle) {
        Optional<List<MovieDAO>> movieByTittle = movieRepository.findByName(tittle);
        if (movieByTittle.isEmpty()) {
            throw new NosuchEntity("please enter a valid tittle");
        }
        return movieByTittle.get().stream().map(x -> mapperMovie.MovieDAO_MovieDTO(x)).collect(Collectors.toList());
    }
}
