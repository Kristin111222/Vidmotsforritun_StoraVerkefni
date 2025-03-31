package com.example.vidmot;
/******************************************************************************
 *  @author Kristín Sesselja Róbertsdóttir
 *  T-póstur: ksr11@hi.is
 *  Viðmótsforritun 2025
 *
 * Notandi getur svarað auka spurningu
 * Tími telur niður, svo lokast glugginn í 0 sek
 *****************************************************************************/

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.util.Callback;
import javafx.util.Duration;
import vinnsla.FeedbackService;

import java.io.IOException;

import static javafx.application.Application.launch;

public class AukaDialogController extends Dialog<String> {

    @FXML
    private Label fxTimer; //Label fyrir Timer

    @FXML
    private Label fxAukaSpurning;
    @FXML
    private TextField fxSvaraAukaSpurningu;
    @FXML
    private TextArea fxFeedbackAukaSpurning;
    private int nidurtalning = 20;
    private Timeline timeline;

    @FXML
    public void onSvaraAukaSpurningu(ActionEvent event) {
        String svarNotanda = fxSvaraAukaSpurningu.getText();

        try {
            String feedback = FeedbackService.provideFeedback2(svarNotanda);
            fxFeedbackAukaSpurning.setText(feedback);

        } catch (Exception e) {
            fxFeedbackAukaSpurning.setText("Villuboð");
            e.printStackTrace();
        }
    }


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

        Timer();
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
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
