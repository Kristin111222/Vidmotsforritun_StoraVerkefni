package com.example.vidmot;
/******************************************************************************
 *  Nafn    : Kristín Sesselja Róbertsdóttir
 *  T-póstur: ksr11@hi.is
 *  Viðmótsforritun 2025
 *
 *  Controller fyrir SvarDialog
 *  getur:
 *
 *  -- svarað spurningu
 *  -- gefið feedback
 *          // selected item er spurningin sem notandinn ætlar að svara-setja reit í scenebuilder
 *         // public SvarDialogController(String selectedItem) {setDialogPane(lesaSvarDialog());
 *****************************************************************************/
import javafx.collections.ObservableList;
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
    private Label fxSpurning; //valin spurning
    @FXML
    private TextField fxSvar; //skrifa inn svarið
    @FXML
    private Label fxLabel2; //feedback
    @FXML
    private Spurningar spurningar;
    @FXML
    private ListView<String> fxSvaradarSpurningar; //listi yfir svaraðar spurningar
    @FXML
    private ListView<String> fxSpurningar; // listi
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
     * @param selectedItem spurningin
     */
    public SvarDialogController(String selectedItem) {
        setDialogPane(lesaSvarDialog());
        fxValinSpurning.setText(selectedItem);
        setResultConverter(b -> {
            if (b.getButtonData().isDefaultButton()) {
                return fxValinSpurning.getText();
            }
            else {
                return null;
            }
        });
    }
    /**
     * Les inn .fxml skrá fyrir DialogPane dialogsins
     * @return DialogPane
     */
    private DialogPane lesaSvarDialog() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("svar-view.fxml"));
        try {
            // controller er settur sem þessi hlutur
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


        /**
         * Hér skrifar maður inn svar, enter er action
         * feedback birtist fyrir neðan svar
         * fjöldi svaraðra spurninga uppfærist í fxLabel1
         * @param event textField
         */
        @FXML
        public void onSvar(ActionEvent event){

                String svarNotanda = fxSvar.getText();
                try {
                    String feedback = FeedbackService.provideFeedback(svarNotanda);
                    fxLabel2.setText(feedback);
                } catch (Exception e) {
                    fxLabel2.setText("Error fetching feedback.");
                    e.printStackTrace();
                }
            }

        public static void main (String[]args){
            Spurningar spurningar = new Spurningar();
            System.out.println(spurningar.getSpurningalisti("Færnispurningar").get(1));
            System.out.println(spurningar.getSpurningalisti("Tæknispurningar").get(0));
            System.out.println(spurningar.getFlokkar());

        }

    }
