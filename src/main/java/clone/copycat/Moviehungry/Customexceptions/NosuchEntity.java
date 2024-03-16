package clone.copycat.Moviehungry.Customexceptions;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class NosuchEntity extends RuntimeException {
    private String additionalMessage;
    private final String errorCode = "1-4";

    public NosuchEntity(String message) {
        super(message);
    }

    public NosuchEntity(String message, String additionalMessage) {
        //super(message);
        this.additionalMessage = additionalMessage;
    }

}
