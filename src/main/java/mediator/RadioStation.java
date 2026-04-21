package mediator;

import java.util.ArrayList;
import java.util.List;

public class RadioStation implements Mediator {
    private List<View> views;

    public RadioStation() {
        this.views = new ArrayList<>();
    }

    public void addViewer(View view){
        this.views.add(view);
    }

    @Override
    public void notifyMediator(Client sender, String message){
        for(View viewer : views) {
            viewer.updateMessages(sender, message);
        }
    }
}
