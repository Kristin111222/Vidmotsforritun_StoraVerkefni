package com.example.vidmot;
/******************************************************************************
 *  @author Kristín Sesselja Róbertsdóttir
 *  T-póstur: ksr11@hi.is
 *  Viðmótsforritun 2025
 *
 * -Notandi gefur einkunn og umsögn
 *****************************************************************************/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.io.IOException;

import static javafx.application.Application.launch;

public class EinkunnDialogController extends Dialog<String> {

    @FXML
    private TextField fxEinkunn;


    @FXML
    public void onEinkunn(ActionEvent event) {
    }


    public EinkunnDialogController() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("einkunn-view.fxml"));
            fxmlLoader.setController(this);
            DialogPane rotin = fxmlLoader.load();
            setDialogPane(rotin);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setResultConverter(new Callback<ButtonType, String>() {
            @Override
            public String call(ButtonType buttonType) {
                String svarNotanda = fxEinkunn.getText().trim();
                return svarNotanda.isEmpty() ? null : svarNotanda;
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }


}


