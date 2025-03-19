package com.example.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

//import static jdk.internal.org.jline.utils.Colors.s;

public class InterviewApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

       FXMLLoader fxmlLoader = new FXMLLoader(InterviewApplication.class.getResource("velkominn-view.fxml"));

       Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.VELKOMINN);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}