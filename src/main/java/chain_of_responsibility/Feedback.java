package chain_of_responsibility;

public class Feedback {
    private String message;
    private String feedBackType;

    public Feedback(String message, String feedBackType){
        this.message = message;
        this.feedBackType = feedBackType;
    }

    public String getFeedBackType(){
        return feedBackType;
    }

    public String getMessage(){
        return message;
    }
}
