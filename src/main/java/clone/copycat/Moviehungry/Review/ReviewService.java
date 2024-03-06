package clone.copycat.Moviehungry.Review;

import clone.copycat.Moviehungry.Customexceptions.NosuchEntity;
import clone.copycat.Moviehungry.Movie.MovieDAO;
import clone.copycat.Moviehungry.Movie.MovieRepository;
import clone.copycat.Moviehungry.Review.DTOs.CreateReviewDTO;
import clone.copycat.Moviehungry.Review.DTOs.ReviewDTO;
import clone.copycat.Moviehungry.Review.mappers.ReviewMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;
    private MovieRepository movieRepository;
    private ReviewMapper reviewMapper;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, MovieRepository movieRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
        this.reviewMapper = reviewMapper;
    }

    public List<ReviewDTO> getAllReviews() {
        List<ReviewDAO> getAllReviews = reviewRepository.findAll();
        return getAllReviews.stream().map(x -> reviewMapper.ReviewDAO_ReviewDTO(x)).collect(Collectors.toList());
    }

    public ReviewDTO getReviewsById(Long id) {
        Optional<ReviewDAO> getreviewById = reviewRepository.findById(id);
        if (getreviewById.isEmpty()) {
            throw new NosuchEntity("so such reviews is present in database");
        }
        return reviewMapper.ReviewDAO_ReviewDTO(getreviewById.get());
    }

    public List<ReviewDTO> getReviewsByMovies(Long movieuuid) {
        Optional<MovieDAO> retrivedMoviedByid = movieRepository.findById(movieuuid);
        if (retrivedMoviedByid.isEmpty()) {
            throw new NosuchEntity("no suck movie exists to be rated");
        }
        Optional<ReviewDAO> retrivedReviewsByMovies = reviewRepository.findByReviewratedMovie(movieuuid);
        return retrivedReviewsByMovies.stream().map(x -> reviewMapper.ReviewDAO_ReviewDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public List<ReviewDTO> setReviews(Long movieuuid, CreateReviewDTO createReviewDTO) {
        Optional<MovieDAO> retrivedMoviedByid = movieRepository.findById(movieuuid);
        if (retrivedMoviedByid.isEmpty()) {
            throw new NosuchEntity("no suck movie exists to be rated");
        }
        ReviewDAO transformed = reviewMapper.CreateReviewDTO_ReviewDAO(createReviewDTO);
        transformed.setRatedMovie(retrivedMoviedByid.get());
        reviewRepository.save(transformed);
        double newrating = 0.0;
        if (retrivedMoviedByid.get().getNumberofReviews() > 0) {
            newrating = (retrivedMoviedByid.get().getMovieRating() + createReviewDTO.getMovieRatings()) / retrivedMoviedByid.get().getNumberofReviews();
        } else {
            newrating = createReviewDTO.getMovieRatings();
        }
        retrivedMoviedByid.get().setMovieRating(newrating);
        retrivedMoviedByid.get().setNumberofReviews(retrivedMoviedByid.get().getNumberofReviews() + 1);
        retrivedMoviedByid.get().getMovieReviews().add(transformed);
        movieRepository.save(retrivedMoviedByid.get());
        Set<ReviewDAO> returnedValue = retrivedMoviedByid.get().getMovieReviews();
        return returnedValue.stream().map(x -> {
            ReviewDTO retreview = reviewMapper.ReviewDAO_ReviewDTO(x);
//            retreview.setNumberOfreview(x.getRatedMovie().getNumberofReviews());
//            retreview.setTotalRating(x.getRatedMovie().getMovieRating());
            return retreview;
        }).collect(Collectors.toList());
    }

}
