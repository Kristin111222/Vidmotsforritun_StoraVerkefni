package com.example.vidmot;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.util.Callback;
import javafx.util.Duration;

import java.io.IOException;

import static javafx.application.Application.launch;

public class AukaDialogController extends Dialog<String> {

    @FXML
    private Label fxTimer; //Label fyrir Timer

    @FXML
    private Label fxAukaSpurning; // Label fyrir auka spurningu
    @FXML
    private TextField fxSvaraAukaSpurningu; //TextField fyrir svarið
    @FXML
    private TextArea fxFeedbackAukaSpurning; //feedback

    private int nidurtalning = 6; // Niðurtalning byrjar í 60 sek
    private Timeline timeline;


    public AukaDialogController() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("auka-view.fxml"));
            fxmlLoader.setController(this);
            DialogPane rotin = fxmlLoader.load();
            setDialogPane(rotin);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setResultConverter(new Callback<ButtonType, String>() {
            @Override
            public String call(ButtonType buttonType) {
                String svarNotanda = fxSvaraAukaSpurningu.getText().trim();
                return svarNotanda.isEmpty() ? null : svarNotanda;
            }
        });

        Timer(); //virka Timer
    }

    /**
     * Býr til Timer sem telur niður sekúndur
     */
    private void Timer() {
        // Búa til timer sem telur niður
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    nidurtalning--;
                    fxTimer.setText("Time remaining: " + nidurtalning + " seconds");

                    // Loka Dialog þegar talning er komin í 0
                    if (nidurtalning <= 0) {
                        timeline.stop();
                       close();
                    }
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE); // Repeat
        timeline.play(); // Byrja Timer
    }


    /**
     * Skrifa inn svar, enter er action
     * @param event TextField
     */
    @FXML
    public void onSvaraAukaSpurningu(ActionEvent event){ //textField enter
        String svarNotanda = fxSvaraAukaSpurningu.getText(); //svarið
    }



    public static void main(String[] args) {
        launch(args);
    }

}
