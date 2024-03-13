package clone.copycat.Moviehungry.Review.mappers;

import clone.copycat.Moviehungry.Movie.DTOs.CreateMovieDTO;
import clone.copycat.Moviehungry.Movie.DTOs.MovieDTO;
import clone.copycat.Moviehungry.Movie.MapperMovie;
import clone.copycat.Moviehungry.Movie.MovieDAO;
import clone.copycat.Moviehungry.Review.DTOs.CreateReviewDTO;
import clone.copycat.Moviehungry.Review.DTOs.ReviewDTO;
import clone.copycat.Moviehungry.Review.ReviewDAO;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring",uses = MapperMovie.class)
@Configuration
public interface ReviewMapper {
    @Mapping(source ="ratedMovie.uuid" ,target="movieId" )
    @Mapping(source ="ratedMovie.name",target="movieName" )
    public ReviewDTO ReviewDAO_ReviewDTO(ReviewDAO ReviewDAO);

    public CreateReviewDTO ReviewDAO_CreateReviewDTO(ReviewDAO ReviewDAO);
    @Mapping(source ="movieId" ,target="ratedMovie.uuid" )
    @Mapping(source ="movieName",target="ratedMovie.name" )
    public ReviewDAO ReviewDTO_ReviewDAO(ReviewDTO ReviewDTO);

    public ReviewDAO CreateReviewDTO_ReviewDAO(CreateReviewDTO CreateReviewDTO);

}
