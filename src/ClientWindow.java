import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ClientWindow extends Application {

    Client client;

    public void startWindow(Client client){

        this.client = client;
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane pane = new Pane();
        ComboBox<Topics> topics = new ComboBox<>();
        Label NewsLabel = new Label();
        Label topicLabel = new Label("Tematy");
        Label subscribedTopicsLabel = new Label("Zasubskrybowane");
        Button subscribeButton = new Button("SUBSCRIBE");
        Button unsubscribeButton = new Button("UNSUBSCRIBE");
        ListView<Topics> subscribedTopicsListView = new ListView<>(FXCollections.observableArrayList(Topics.values()));

        NewsLabel.setText("Temat: Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut non urna vitae massa consequat maximus.");
        NewsLabel.setWrapText(true);
        NewsLabel.setMaxWidth(190);
        NewsLabel.setLayoutX(250);
        NewsLabel.setLayoutY(20);

        subscribedTopicsLabel.setLayoutX(130);
        subscribedTopicsLabel.setLayoutY(20);

        subscribedTopicsListView.setLayoutX(130);
        subscribedTopicsListView.setLayoutY(40);
        subscribedTopicsListView.setMouseTransparent(true);
        subscribedTopicsListView.setFocusTraversable(false);
        subscribedTopicsListView.setMaxSize(100, 95);

        topicLabel.setLayoutX(10);
        topicLabel.setLayoutY(20);

        topics.getItems().setAll(Topics.values());
        topics.setLayoutX(10);
        topics.setLayoutY(40);

        subscribeButton.setPrefSize(100,20);
        subscribeButton.setLayoutX(10);
        subscribeButton.setLayoutY(90);
        unsubscribeButton.setPrefSize(100,20);
        unsubscribeButton.setLayoutX(10);
        unsubscribeButton.setLayoutY(120);

        pane.getChildren().addAll(topicLabel, subscribeButton, unsubscribeButton, topics, subscribedTopicsLabel, subscribedTopicsListView, NewsLabel);
        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        subscribeButton.setOnAction(event -> {

        });

        unsubscribeButton.setOnAction(event -> {

        });
    }
}
