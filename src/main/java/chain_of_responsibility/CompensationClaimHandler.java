package chain_of_responsibility;

public class CompensationClaimHandler extends FeedbackHandler {

    @Override
    public void handleFeedback(Feedback feedback) {
        if (feedback.getFeedBackType().toLowerCase().contains("compensation")){
            System.out.println("Compensation handled, the user will be compensated in 2 days.");
        } else {
            System.out.println("Cannot handle feedback type, sending to next handler.");
            super.handleFeedback(feedback);
        }
    }
}
