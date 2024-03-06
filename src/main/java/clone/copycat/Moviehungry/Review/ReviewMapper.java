package clone.copycat.Moviehungry.Review;

import clone.copycat.Moviehungry.Movie.DTOs.CreateMovieDTO;
import clone.copycat.Moviehungry.Movie.DTOs.MovieDTO;
import clone.copycat.Moviehungry.Movie.MovieDAO;
import clone.copycat.Moviehungry.Review.DTOs.CreateReviewDTO;
import clone.copycat.Moviehungry.Review.DTOs.ReviewDTO;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Configuration;

@Mapper(componentModel = "spring")
@Configuration
public interface ReviewMapper {
//    @Mapping(target = "numberOfreview", ignore = true)
//    @Mapping(target = "totalRating", ignore = true)
    public ReviewDTO ReviewDAO_ReviewDTO(ReviewDAO ReviewDAO);
    public CreateReviewDTO ReviewDAO_CreateReviewDTO(ReviewDAO ReviewDAO);
    public ReviewDAO ReviewDTO_ReviewDAO(ReviewDTO ReviewDTO);
    public ReviewDAO CreateReviewDTO_ReviewDAO(CreateReviewDTO CreateReviewDTO);

}
