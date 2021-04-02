package main;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Context;
import view.SceneManager;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        SceneManager.getInstance().setAppName("MegaInvoice");
        SceneManager.createApp(primaryStage, "loginPage", 1165, 720);
        Context.debug("TEST");
    }

    public static void main(String[] args) {
        launch(args);
    }
}