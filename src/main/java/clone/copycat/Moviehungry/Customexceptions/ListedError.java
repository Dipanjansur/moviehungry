package clone.copycat.Moviehungry.Customexceptions;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class ListedError extends RuntimeException{
    List<RuntimeException> listoferrors;
    private final String errorCode = "11-0";

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
