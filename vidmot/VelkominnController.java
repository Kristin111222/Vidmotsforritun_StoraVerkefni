package com.example.vidmot;
/******************************************************************************
 *  @author Kristín Sesselja Róbertsdóttir
 *  T-póstur: ksr11@hi.is
 *  Viðmótsforritun 2025
 *
 *  Controller fyrir Velkominn
 *  getur:
 *
 *  -- valið að svara spurningum
 *  -- Hætt
 *****************************************************************************/

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;

import java.awt.*;
import java.net.URI;

import static javafx.application.Application.launch;


public class VelkominnController {

    @FXML
    private CheckBox fxCheckBox;
    @FXML
    private Button fxSpurningar;
    @FXML
    private Hyperlink fxLinkur;

    private HostServices hostServices;


    /**
     * frumstillir
     * Gerir spurningar hnapp óvirkann
     * Setur listener á checkBox
     */
    public void initialize() {
        fxSpurningar.setDisable(true);

        fxCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {

            fxSpurningar.setDisable(false);
        });
    }


    public void onCheckBox(ActionEvent event) {

    }




    public void onLinkur(ActionEvent event) {
        try {
            String url = "https://openai.com/policies/terms-of-use/";
            URI uri = new URI(url);

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(uri);  // Opens in default web browser
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
         * Opna spurninga glugga
         *
         * @param event
         */
    public void onSpurningar(ActionEvent event) {

        ViewSwitcher.switchTo(View.SPURNINGAR);
    }

    /**
     * Skipta yfir í kveðju glugga
     *
     * @param event
     */
    public void onHaetta1(ActionEvent event) {

        ViewSwitcher.switchTo(View.KVEDJA);
    }


    public static void main(String[] args) {
        launch();


       // String chromePath;
       // System.out.println("Chrome Path: "+chromePath);
}


}







