import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdminWindow extends Application {

    public static Request request;

    public void startWindow(Request request ){
        AdminWindow.request = request;
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane pane = new Pane();
        ComboBox<Topics> topicsComboBox = new ComboBox<>();
        TextArea newsTextArea = new TextArea();
        Label topicLabel = new Label("Tematy");
        Button sendButton = new Button("SEND");

        topicLabel.setLayoutX(25);
        topicLabel.setLayoutY(20);

        newsTextArea.setPrefSize(225,100);
        newsTextArea.setLayoutX(200);
        newsTextArea.setLayoutY(20);
        newsTextArea.setWrapText(true);

        topicsComboBox.getItems().setAll(Topics.values());
        topicsComboBox.setLayoutY(40);
        topicsComboBox.setLayoutX(25);

        sendButton.setPrefSize(100,20);
        sendButton.setLayoutX(25);
        sendButton.setLayoutY(90);

        pane.getChildren().addAll(topicLabel, sendButton, topicsComboBox, newsTextArea);
        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Admin");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        sendButton.setOnAction(event -> {
            request.topic = topicsComboBox.getValue().toString();
            request.news = newsTextArea.getText();
        });
    }
}
