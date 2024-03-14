package clone.copycat.Moviehungry.Movie.DTOs;

import clone.copycat.Moviehungry.Movie.Genre;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.AssertTrue;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CreateMovieDTO {
    private String name;
    private LocalDate releaseyear;
    private long uniqueId;
    @Enumerated(EnumType.STRING)
    private Genre movieGenre;
    public void setName(String name) {
        // Trim the name and convert to lowercase
        this.name = name.trim().toLowerCase();
    }
    public void setMovieGenre(Genre movieGenre) {
        if (movieGenre != null) {
            this.movieGenre = movieGenre;
        }else{
            this.movieGenre = Genre.UNKNOWN;
        }
    }
    @AssertTrue(message = "Release year must be after 1990")
    public boolean setreleaseYear() {
        return releaseyear == null || releaseyear.isAfter(LocalDate.of(1990, 12, 31));
    }
}
