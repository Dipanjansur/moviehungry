package clone.copycat.Moviehungry;

import clone.copycat.Moviehungry.Customexceptions.IllegalArguments;
import clone.copycat.Moviehungry.Customexceptions.NotValidArguments;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = { NoSuchFieldException.class, IllegalArguments.class, NotValidArguments.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> mapInvalidCallException(RuntimeException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

//    @ExceptionHandler(value = NoSuchMethodError.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<String> handleIllegalArguments(IllegalArguments ex) {
//        return ResponseEntity.badRequest().body("Illegal arguments exception occurred: " + ex.getMessage());
//    }
}
