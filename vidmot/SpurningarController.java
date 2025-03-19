package com.example.vidmot;
/******************************************************************************
 *  Nafn    : Kristín Sesselja Róbertsdóttir
 *  T-póstur: ksr11@hi.is
 *  Viðmótsforritun 2025
 *
 *  Controller fyrir Spurningar
 *  getur:
 *
 *  -- valið flokk
 *  -- valið spurningu
 *  -- Sýnt lista yfir svaraðar spurningar
 *  -- Sýnt fjölda svaraðra spurninga
 *****************************************************************************/
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import vinnsla.Spurningar;

import java.util.Optional;

public class SpurningarController {

    @FXML
    private Label fxSpurning; // núverandi spurning sem er verið að svara

    @FXML
    private Label fxLabel1; //fjöldi svaraðra spurninga

    @FXML
    private ListView<String> fxFlokkar; //listi með 2 flokkur

    @FXML
    private ListView<String> fxSpurningar; // spurningar úr flokki

    @FXML
    private ListView<String> fxSvaradarSpurningar; //listi...

    private int virkurIndex=0;

    private Spurningar spurningar = new Spurningar();


    /** setur flokka í ListView, Listener fyrir valið, sækir spurningalistann
     * initialize
     */
    public void initialize() {
        ObservableList<String> flokkar = FXCollections.observableArrayList(spurningar.getFlokkar());
        fxFlokkar.setItems(flokkar);
        fxFlokkar.getSelectionModel().selectedIndexProperty()
                .addListener((obs, old, newIndex) -> {
                    virkurIndex = newIndex.intValue();
                    if (virkurIndex >= -1) {
                        String selectedCategory = fxFlokkar.getItems().get(virkurIndex);
                        ObservableList<String> spurningarnar = FXCollections.observableArrayList(spurningar.getSpurningalisti(selectedCategory));
                        fxSpurningar.setItems(spurningarnar);
                    }
                });
    }


    /**
     * Opna Dialog
     * @param event - Svara hnappur
     */
    public void onSvara(ActionEvent event){
        SvarDialogController svarDialogController = new SvarDialogController();
        Optional<String> result = svarDialogController.showAndWait();
        if(result.isPresent()) {
            spurningar.haekkaFjoldiSpurning();
            fxLabel1.setText("Fjöldi svaraðra spurninga er: " + spurningar.getFjoldiSvaradraSpurninga());
        } else{
    }}

    /**
     * Fara aftur í velkominn gluggann
     * @param event - Til baka hnappur
     */
    public void onTilBaka(ActionEvent event){
        ViewSwitcher.switchTo(View.VELKOMINN);
    }

    /**
     * Fara í kveðju gluggann
     * @param event - Hætta hnappur
     */
    public void onHaetta2(ActionEvent event){
        ViewSwitcher.switchTo(View.KVEDJA);
    }
}
