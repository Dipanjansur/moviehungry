package clone.copycat.Moviehungry.Movie;

import clone.copycat.Moviehungry.Customexceptions.NosuchEntity;
import clone.copycat.Moviehungry.Movie.DTOs.CreateMovieDTO;
import clone.copycat.Moviehungry.Movie.DTOs.MovieDTO;
import clone.copycat.Moviehungry.Users.UsersDAO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class MovieService {
    private MovieRepository movieRepository;
    private MapperMovie mapperMovie;

    @Autowired
    public MovieService(MovieRepository movieRepository, MapperMovie mapperMovie) {
        this.movieRepository = movieRepository;
        this.mapperMovie = mapperMovie;
    }

    public List<MovieDTO> getAllMovies() {
        List<MovieDAO> allMovies = movieRepository.findAll();
        return allMovies.stream().map(x -> mapperMovie.MovieDAO_MovieDTO(x)).collect(Collectors.toList());
    }

    public MovieDTO addMovie(CreateMovieDTO createMovieDTO) {
        Optional<MovieDAO> ifMovieExits = movieRepository.findByUniqueId(createMovieDTO.getUniqueId());
        if (ifMovieExits.isPresent()) {
            throw new NosuchEntity("A movie is already preasent with the same Id");
        } else {
            MovieDAO transformed = mapperMovie.MovieDAO_CreateMovieDTO(createMovieDTO);
            movieRepository.save(transformed);
            return mapperMovie.MovieDAO_MovieDTO(transformed);
        }
    }

    public MovieDTO findMovieByidOruuid(Long id, Long uuid) {
        Optional<MovieDAO> founduser;
        if (id != null) {
            founduser = movieRepository.findById(id);
        } else {
            founduser = movieRepository.findByUniqueId(uuid);
        }
        if (founduser.isEmpty()) {
            throw new NosuchEntity("No such user is present in the platform");
        }
        return mapperMovie.MovieDAO_MovieDTO(founduser.get());
    }

    public List<MovieDTO> findMovieByTittle(String tittle) {
        Optional<List<MovieDAO>> movieByTittle = movieRepository.findByName(tittle);
        if (movieByTittle.isEmpty()) {
            throw new NosuchEntity("please enter a valid tittle");
        }
        return movieByTittle.get().stream().map(x -> mapperMovie.MovieDAO_MovieDTO(x)).collect(Collectors.toList());
    }
}
