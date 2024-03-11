package clone.copycat.Moviehungry.Customexceptions;

public class DouplicateEntity extends RuntimeException{
    private String additionalMessage;
    private final String errorCode = "1-0";

    public DouplicateEntity(String message) {
        super(message);
    }

    public DouplicateEntity(String message, String additionalMessage) {
        super(message);
        this.additionalMessage = additionalMessage;
    }
}
