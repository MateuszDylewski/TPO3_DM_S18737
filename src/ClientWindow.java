import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ClientWindow extends Application {

    public static Request request;
    public static StringProperty news;

    public void startWindow(Request request ){
        ClientWindow.request = request;
        news = new SimpleStringProperty("");
        Platform.setImplicitExit(false);
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane pane = new Pane();
        ComboBox<Topics> topicsComboBox = new ComboBox<>();
        Label newsLabel = new Label();
        Label topicLabel = new Label("Tematy");
        Button subscribeButton = new Button("SUBSCRIBE");
        Button unsubscribeButton = new Button("UNSUBSCRIBE");

        newsLabel.setText("Brak nowy wiadomosci.");
        newsLabel.setWrapText(true);
        newsLabel.setMaxWidth(225);
        newsLabel.setLayoutX(200);
        newsLabel.setLayoutY(20);
        newsLabel.textProperty().bind(news);

        topicLabel.setLayoutX(25);
        topicLabel.setLayoutY(20);

        topicsComboBox.getItems().setAll(Topics.values());
        topicsComboBox.setLayoutX(25);
        topicsComboBox.setLayoutY(40);

        subscribeButton.setPrefSize(100,20);
        subscribeButton.setLayoutX(25);
        subscribeButton.setLayoutY(90);
        unsubscribeButton.setPrefSize(100,20);
        unsubscribeButton.setLayoutX(25);
        unsubscribeButton.setLayoutY(120);

        pane.getChildren().addAll(topicLabel, subscribeButton, unsubscribeButton, topicsComboBox, newsLabel);
        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Client");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        subscribeButton.setOnAction(event -> {

            request.topic = "SUB " + topicsComboBox.getValue();
        });

        unsubscribeButton.setOnAction(event -> {

            request.topic = "UNSUB " + topicsComboBox.getValue();
        });
    }
}
