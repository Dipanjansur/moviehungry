package clone.copycat.Moviehungry.Review;

import clone.copycat.Moviehungry.Review.DTOs.CreateReviewDTO;
import clone.copycat.Moviehungry.Review.DTOs.ReviewDTO;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {
    private ReviewService reviewService;

    @Autowired
    public ReviewsController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getReviewsById(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.getReviewsById(id));
    }

    @GetMapping("movies/{movieuuid}")
    public ResponseEntity<List<ReviewDTO>> getReviewsByMovies(@PathVariable Long movieuuid) {
        return ResponseEntity.ok(reviewService.getReviewsByMovies(movieuuid));
    }

    @PostMapping("/movies/{movieuuid}")
    public ResponseEntity<List<ReviewDTO>> setReviews(@PathVariable Long movieuuid, @Validated @RequestBody CreateReviewDTO createReviewDTO) {
        return ResponseEntity.ok(reviewService.setReviews(movieuuid,createReviewDTO));
    }
}
