package chain_of_responsibility;

public class Main {
    public static void main(String[] args) {
        Handler general = new GeneralFeedBackHandler();
        Handler contact = new ContactRequestHandler();
        Handler compensation = new CompensationClaimHandler();
        Handler development = new DevelopmentSuggestionHandler();

        general.setNextHandler(contact);
        contact.setNextHandler(development);
        development.setNextHandler(compensation);

        Feedback f1 = new Feedback(FeedbackType.COMPENSATION, "Paid but i never received the damn product.", "user1@123123.com");
        Feedback f2 = new Feedback(FeedbackType.DEVELOPMENT, "Add dark mode to this app please", "user2@ddawdaw.com");
        Feedback f3 = new Feedback(FeedbackType.CONTACT, "Need help with login", "user3@fwefwefwe.com");

        System.out.println("Processing Feedback 1:");
        general.handleFeedback(f1);

        System.out.println("\nProcessing Feedback 2:");
        general.handleFeedback(f2);

        System.out.println("\nProcessing Feedback 3:");
        general.handleFeedback(f3);
    }
}