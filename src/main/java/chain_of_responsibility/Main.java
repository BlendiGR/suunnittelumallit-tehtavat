package chain_of_responsibility;

public class Main {
    public static void main(String[] args) {
        Handler general = new GeneralFeedBackHandler();
        Handler contact = new ContactRequestHandler();
        Handler compensation = new CompensationClaimHandler();

        general.setNextHandler(contact);
        contact.setNextHandler(compensation);

        //
        Feedback myFeedback = new Feedback("I LOST ALL OF MY MONEY BECAUSE OF YUOU!!!!", "compensation");
        general.handleFeedback(myFeedback);
    }
}
