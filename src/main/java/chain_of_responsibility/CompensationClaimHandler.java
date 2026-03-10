package chain_of_responsibility;

public class CompensationClaimHandler extends FeedbackHandler {
    @Override
    public void handleFeedback(Feedback feedback) {
        if (feedback.getType() == FeedbackType.COMPENSATION) {
            System.out.println("Claim handled for " + feedback.getSenderEmail() + ". User will be compensated in 2 days.");
        } else {
            super.handleFeedback(feedback);
        }
    }
}