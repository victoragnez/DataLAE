package gui;

import gui.screens.LoggedIn;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new LoggedIn());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}