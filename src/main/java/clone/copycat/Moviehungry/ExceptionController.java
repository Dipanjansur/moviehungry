package clone.copycat.Moviehungry;

import clone.copycat.Moviehungry.Customexceptions.IllegalArguments;
import clone.copycat.Moviehungry.Customexceptions.ListedError;
import clone.copycat.Moviehungry.Customexceptions.NosuchEntity;
import clone.copycat.Moviehungry.Customexceptions.NotValidArguments;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLSyntaxErrorException;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = {NoSuchFieldException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> mapInvalidCallException(RuntimeException ex, WebRequest request) {
        return ResponseEntity.badRequest().body("please pass some valid argument to continue----->" + ex.getCause().getMessage());
    }

    @ExceptionHandler(SQLSyntaxErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleSQLSyntaxErrorException(RuntimeException ex) {
        return ResponseEntity.badRequest().body("something wrong with SQL----->" + ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleIllegalArguments(RuntimeException ex) {
        return ResponseEntity.badRequest().body("please pass some valid data format---->" + ex.getCause().getMessage());
    }

    @ExceptionHandler(OptimisticLockingFailureException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleOptimisticLockingFailureException(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ResponseEntity.badRequest().body("Invalid request payload: " + ex.getMessage());
    }

    @ExceptionHandler(NotValidArguments.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleNotValidArguments(NotValidArguments ex) {
        return ResponseEntity.badRequest().body("this is an invalid argument----->" + ex);
    }

    @ExceptionHandler(IllegalArguments.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleIllegalArguments(IllegalArguments ex) {
        return ResponseEntity.badRequest().body(ex);
    }

    @ExceptionHandler(ListedError.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleIllegalArguments(ListedError ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("errors",ex.getListoferrors());
        body.put("errorCode","1-30");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(NosuchEntity.class)
    public ResponseEntity<Object> handleNosuchEntity(NosuchEntity nonNosuchEntity) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", nonNosuchEntity.getMessage());
        body.put("errorCode", nonNosuchEntity.getErrorCode());
        body.put("additionalMessage", nonNosuchEntity.getAdditionalMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }


}
