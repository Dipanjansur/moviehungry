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
    public ResponseEntity<HashMap<String,String>> mapInvalidCallException(RuntimeException ex, WebRequest request) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("message",ex.getMessage());
        map.put("cause",ex.getCause().toString());
        return ResponseEntity.badRequest().body(map);
    }

    @ExceptionHandler(SQLSyntaxErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<HashMap<String,String>> handleSQLSyntaxErrorException(RuntimeException ex) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("message",ex.getMessage());
        map.put("cause",ex.getCause().toString());
        return ResponseEntity.badRequest().body(map);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap<String,String>> handleIllegalArguments(RuntimeException ex) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("message",ex.getMessage());
        map.put("cause",ex.getCause().toString());
        return ResponseEntity.badRequest().body(map);
    }

    @ExceptionHandler(OptimisticLockingFailureException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<HashMap<String,String>> handleOptimisticLockingFailureException(RuntimeException ex) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("message",ex.getMessage());
        map.put("cause",ex.getCause().toString());
        return ResponseEntity.badRequest().body(map);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap<String,String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("message",ex.getMessage());
        map.put("cause",ex.getCause().toString());
        return ResponseEntity.badRequest().body(map);
    }

    @ExceptionHandler(NotValidArguments.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap<String,String>> handleNotValidArguments(NotValidArguments ex) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("message",ex.getMessage());
        map.put("cause",ex.getCause().toString());
        return ResponseEntity.badRequest().body(map);
    }

    @ExceptionHandler(IllegalArguments.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<HashMap<String,String>> handleIllegalArguments(IllegalArguments ex) {
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("message",ex.getMessage());
        map.put("cause",ex.getCause().toString());
        return ResponseEntity.badRequest().body(map);
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
