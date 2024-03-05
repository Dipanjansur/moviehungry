package clone.copycat.Moviehungry.Customexceptions;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NosuchEntity extends RuntimeException{
    private String additionalMessage;
    private final String errorCode="1-0";

}
