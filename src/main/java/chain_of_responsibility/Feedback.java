package chain_of_responsibility;

public class Feedback {
    private String message;
    private String senderEmail;
    private FeedbackType type;

    public Feedback(FeedbackType type, String message, String senderEmail) {
        this.type = type;
        this.message = message;
        this.senderEmail = senderEmail;
    }

    public FeedbackType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getSenderEmail() {
        return senderEmail;
    }
}