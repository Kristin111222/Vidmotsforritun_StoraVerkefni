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

import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;


public class VelkominnController {

    @FXML
    private CheckBox fxCheckBox;
    @FXML
    private Button fxSpurningar;
    @FXML
    private Hyperlink fxLinkur;


    /**
     * frumstillir
     * Gerir spurningar hnapp óvirkann
     * Setur listener á checkBox
     */
    public void initialize() {
        fxSpurningar.setDisable(true);

        fxCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {

            fxSpurningar.setDisable(!newValue);
        });
    }


    public void onCheckBox(ActionEvent event) {

    }


    /**
     * Ýta á linkinn- linkur opnast
     *
     * @param event
     */
    public void onLinkur(ActionEvent event) {
        ObservableMap<Object, Object> hostServices = fxLinkur.getScene().getWindow().getProperties();
        hostServices.get("https://openai.com/policies/terms-of-use/");
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
}







