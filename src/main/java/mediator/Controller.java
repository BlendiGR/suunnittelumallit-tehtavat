package mediator;

import javafx.application.Application;
import javafx.stage.Stage;

public class Controller extends Application {

    @Override
    public void start(Stage stage) {
        Client client = new Client("BlendG");
        Client client2 = new Client("AleksPut");
        Client client3 = new Client("Bugi");
        RadioStation radioStation = new RadioStation();

        View view1 = new View(client, radioStation);
        View view2 = new View(client2, radioStation);
        View view3 = new View(client3, radioStation);

        radioStation.addViewer(view1);
        radioStation.addViewer(view2);
        radioStation.addViewer(view3);

        view1.show(stage);
        view2.show(new javafx.stage.Stage());
        view3.show(new javafx.stage.Stage());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
