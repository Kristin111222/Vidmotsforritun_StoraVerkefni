package com.example.vidmot;
/******************************************************************************
 *  Nafn    : Kristín Sesselja Róbertsdóttir
 *  T-póstur: ksr11@hi.is
 *  Viðmótsforritun 2025
 *
 *  Controller fyrir Velkominn
 *  getur:
 *
 *  -- valið að svara spurningum
 *  -- Hætt
 *****************************************************************************/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import vinnsla.Spurningar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.vidmot.View.SPURNINGAR;
//import static jdk.jpackage.internal.IOUtils.getFileName;

public class VelkominnController {



    public void onSpurningar(ActionEvent event) throws IOException {

      ViewSwitcher.switchTo(View.SPURNINGAR);


    }

    public void onHaetta1(ActionEvent event) {

        ViewSwitcher.switchTo(View.KVEDJA);
    }
}







