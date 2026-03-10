package chain_of_responsibility;

public abstract class FeedbackHandler implements Handler {

    private Handler nextHandler;

    @Override
    public void handleFeedback(Feedback feedback){
        if (nextHandler != null){
            nextHandler.handleFeedback(feedback);
        }
    }

    public void setNextHandler(Handler handler){
        this.nextHandler = handler;
    }
}
