package com.example.vidmot;
/******************************************************************************
 *  @author Kristín Sesselja Róbertsdóttir
 *  T-póstur: ksr11@hi.is
 *  Viðmótsforritun 2025
 *
 * Interview Application
 * -opnar fyrsta gluggann
 * -býður manni velkominn
 *****************************************************************************/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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