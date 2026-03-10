package chain_of_responsibility;

public class ContactRequestHandler extends FeedbackHandler {
    @Override
    public void handleFeedback(Feedback feedback) {
        if (feedback.getFeedBackType().toLowerCase().contains("contact")){
            System.out.println("Message sent to user containing the company's contact details. (044 1234567 company@company.fi)");
        } else {
            System.out.println("Cannot handle feedback type, sending to next handler.");
            super.handleFeedback(feedback);
        }
    }
}
