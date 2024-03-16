package clone.copycat.Moviehungry.Customexceptions;

public class IllegalArguments extends  RuntimeException{
    private String additionalMessage;
    private final String errorCode = "1-1";

    public IllegalArguments(String message) {
        super(message);
    }

    public IllegalArguments(String message, String additionalMessage) {
        super(message);
        this.additionalMessage = additionalMessage;
    }
}
