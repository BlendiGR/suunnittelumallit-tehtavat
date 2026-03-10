package chain_of_responsibility;

public class GeneralFeedBackHandler extends FeedbackHandler {

    @Override
    public void handleFeedback(Feedback feedback) {
        if (feedback.getType() == FeedbackType.GENERAL ){
            System.out.println("Thank you for leaving us feedback, we will take into account the feedback you left us asap.");
        } else {
            System.out.println("Cannot handle feedback type, sending to next handler.");
            super.handleFeedback(feedback);
        }
    }
}
