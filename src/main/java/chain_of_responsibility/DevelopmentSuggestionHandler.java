package chain_of_responsibility;

public class DevelopmentSuggestionHandler extends FeedbackHandler {
    @Override
    public void handleFeedback(Feedback feedback) {
        if (feedback.getType() == FeedbackType.DEVELOPMENT) {
            System.out.println("Suggestion logged and prioritized from: " + feedback.getSenderEmail());
        } else {
            super.handleFeedback(feedback);
        }
    }
}