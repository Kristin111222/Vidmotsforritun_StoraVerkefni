package com.example.vidmot;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.util.Callback;

import java.io.IOException;

public class EinkunnDialogController extends Dialog<String> {

    private Label fxEinkunn;

    public EinkunnDialogController() {

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
                String svarNotanda = fxEinkunn.getText().trim();
                return svarNotanda.isEmpty() ? null : svarNotanda;
            }
        });
    }
}


