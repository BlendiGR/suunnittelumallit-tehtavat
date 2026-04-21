package mediator;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class View {

    private final Client client;
    private final Mediator mediator;
    private VBox messageContainer;

    public View(Client client, Mediator mediator) {
        this.client = client;
        this.mediator = mediator;
    }

    public void show(Stage stage) {
        messageContainer = new VBox(6);
        messageContainer.setPadding(new Insets(10));

        ScrollPane scrollPane = new ScrollPane(messageContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setVvalue(1.0);
        messageContainer.heightProperty().addListener(o -> scrollPane.setVvalue(1.0));
        VBox.setVgrow(scrollPane, Priority.ALWAYS);

        TextField inputField = new TextField();
        inputField.setPromptText("Type a message...");
        HBox.setHgrow(inputField, Priority.ALWAYS);

        Button sendButton = new Button("Send");
        sendButton.setDefaultButton(true);

        HBox inputBar = new HBox(8, inputField, sendButton);
        inputBar.setPadding(new Insets(8));
        inputBar.setAlignment(Pos.CENTER);

        VBox root = new VBox(scrollPane, inputBar);
        root.setPrefSize(400, 500);

        Runnable sendAction = () -> {
            String text = inputField.getText().trim();
            if (text.isEmpty()) return;
            mediator.notifyMediator(client, text);
            inputField.clear();
        };

        sendButton.setOnAction(e -> sendAction.run());
        inputField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) sendAction.run();
        });

        stage.setTitle("Chat — " + client.getUsername());
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void updateMessages(Client sender, String message){
        appendMessage(sender.getUsername(), message);
    }

    private void appendMessage(String username, String message) {
        Text sender = new Text(username + ": ");
        sender.setStyle("-fx-font-weight: bold;");
        Text content = new Text(message);
        TextFlow line = new TextFlow(sender, content);
        line.setPadding(new Insets(2, 6, 2, 6));
        messageContainer.getChildren().add(line);
    }
}
