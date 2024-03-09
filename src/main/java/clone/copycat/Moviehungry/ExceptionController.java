package clone.copycat.Moviehungry;

import clone.copycat.Moviehungry.Customexceptions.IllegalArguments;
import clone.copycat.Moviehungry.Customexceptions.NosuchEntity;
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

    @ExceptionHandler(NosuchEntity.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleNosuchEntity(NosuchEntity ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.BAD_GATEWAY)
//    public ResponseEntity<String> handleIllegalArguments(RuntimeException ex) {
//        return ResponseEntity.badRequest().body("RUntime exceptions" + ex.getMessage());
//    }
}
