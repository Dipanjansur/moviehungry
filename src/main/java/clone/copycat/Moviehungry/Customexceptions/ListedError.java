package clone.copycat.Moviehungry.Customexceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
//@NoArgsConstructor
public class ListedError extends RuntimeException{
    List<RuntimeException> listoferrors;
    private final String errorCode = "1-3";

    public ListedError() {
        super();
    }

    public ListedError(String message,List<RuntimeException> listerror) {
        super(message);
        this.listoferrors = listerror;
    }
    public List<RuntimeException>  addErrors(RuntimeException error){
        listoferrors.add(error);
        return listoferrors;
    }
}
