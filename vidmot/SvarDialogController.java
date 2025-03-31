package com.example.vidmot;
/******************************************************************************
 *  @author Kristín Sesselja Róbertsdóttir
 *  T-póstur: ksr11@hi.is
 *  Viðmótsforritun 2025
 *
 *  Controller fyrir SvarDialog
 *  getur:
 *
 *  -- svarað spurningu
 *  -- gefið feedback
 *****************************************************************************/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.util.Callback;
import vinnsla.FeedbackService;
import vinnsla.Spurningar;

import java.io.IOException;


public class SvarDialogController extends Dialog<String> {

    @FXML
    private Label fxValinSpurning;
    @FXML
    private Label fxSpurning;
    @FXML
    private TextField fxSvar;
    @FXML
    private TextArea fxLabel2;
    @FXML
    private Spurningar spurningar;
    @FXML
    private ListView<String> fxSvaradarSpurningar;
    @FXML
    private ListView<String> fxSpurningar;

    /**
     * Setja controllerinn
     */
    public SvarDialogController() {
        spurningar = new Spurningar();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("svar-view.fxml"));

            fxmlLoader.setController(this);
            DialogPane rotin = fxmlLoader.load();
            setDialogPane(rotin);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setResultConverter(new Callback<ButtonType, String>() {
            @Override
            public String call(ButtonType buttonType) {
                String svarNotanda = fxSvar.getText().trim();
                return svarNotanda.isEmpty() ? null : svarNotanda;
            }
        });
    }

    /**
     * Smiður sem setur spurningu í spurningareitinn
     * Setur upp resultConverter sem skilar spurningunni
     *
     * @param selectedItem spurningin
     */
    public SvarDialogController(String selectedItem) {
        setDialogPane(lesaSvarDialog());
        fxValinSpurning.setText(selectedItem);
        setResultConverter(b -> {
            if (b.getButtonData().isDefaultButton()) {
                return fxValinSpurning.getText();
            } else {
                return null;
            }
        });
    }

    /**
     * Les inn .fxml skrá fyrir DialogPane dialogsins
     *
     * @return DialogPane
     */
    private DialogPane lesaSvarDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("svar-view.fxml"));
        try {

            fxmlLoader.setController(this);
            return fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


    /**
     * Hér skrifar maður inn svar, enter er action
     * feedback birtist fyrir neðan svar
     * fjöldi svaraðra spurninga uppfærist í fxLabel1
     *
     * @param event textField
     */
    @FXML
    public void onSvar(ActionEvent event) { // svar og ýta á enter

        String svarNotanda = fxSvar.getText();
        String selectedItem = fxValinSpurning.getText();

        try {
            String feedback = FeedbackService.provideFeedback(selectedItem, svarNotanda);

            fxLabel2.setText(feedback);
            fxLabel2.setWrapText(true);

        } catch (Exception e) {
            fxLabel2.setText("Error fetching feedback.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

}
