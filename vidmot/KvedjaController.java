package com.example.vidmot;
/******************************************************************************
 *  @author Kristín Sesselja Róbertsdóttir
 *  T-póstur: ksr11@hi.is
 *  Viðmótsforritun 2025
 *
 *  Controller fyrir Kveðju
 *  getur:
 *
 *  - lokað forritinu
 *****************************************************************************/

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class KvedjaController {

    /**
     * Loka forritinu
     *
     * @param event Hætta hnappur
     */
    public void onHaetta4(ActionEvent event) {

        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.close();
    }
}
