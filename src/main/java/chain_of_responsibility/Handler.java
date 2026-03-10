package chain_of_responsibility;

public interface Handler {
    void handleFeedback(Feedback feedback);
    void setNextHandler(Handler handler);
}
