package clone.copycat.Moviehungry.Movie;

import clone.copycat.Moviehungry.Movie.DTOs.CreateMovieDTO;
import clone.copycat.Moviehungry.Movie.DTOs.MovieDTO;
import clone.copycat.Moviehungry.Review.mappers.ReviewMapper;
import clone.copycat.Moviehungry.Show.Mapper.ShowMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring",uses= {ReviewMapper.class, ShowMapper.class})
@Configuration
public interface MapperMovie {
   MapperMovie INSTANCE = Mappers.getMapper(MapperMovie.class);
   public MovieDTO MovieDAO_MovieDTO(MovieDAO moviedao);
   public  MovieDAO MovieDAO_MovieDTO(MovieDTO movieDTO);
   public CreateMovieDTO  MovieDAO_CreateMovieDTO(MovieDAO moviedao);
   public MovieDAO  MovieDAO_CreateMovieDTO(CreateMovieDTO movieDTO);
}
