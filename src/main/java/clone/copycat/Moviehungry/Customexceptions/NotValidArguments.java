package clone.copycat.Moviehungry.Customexceptions;

import lombok.*;

@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotValidArguments extends  RuntimeException{
    private String additionalMessage;
    private String resoluitions;
    private final String errorCode="2-0";
    public NotValidArguments(String message) {
        super(message);
    }

    public NotValidArguments(String message, String additionalMessage) {
        //super(message);
        this.additionalMessage = additionalMessage;
    }
}
