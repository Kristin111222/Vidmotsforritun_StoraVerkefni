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
         * Hér skrifar maður inn svar, enter er action
         * feedback birtist fyrir neðan svar
         * fjöldi svaraðra spurninga uppfærist í fxLabel1
         * @param event textField
         */
        @FXML
        public void onSvar(ActionEvent event){

               // spurningar.fjoldiSvaradraSpurninga();
                //fxLabel1.setText("Fjöldi svaraðra spurninga er: " + spurningar.getFjoldiSvaradraSpurninga());
                String svarNotanda = fxSvar.getText().trim();
                String feedback = FeedbackService.provideFeedback(svarNotanda);
                //birta valda spurningu í fxSvaradarSpurningar
                fxLabel2.setText(feedback);
                //setja valda spurningu í ListView
               // String valinSpurning = fxSpurningar.getSelectionModel().getSelectedItem();
                //fxSvar.clear();
                //ObservableList<String> valinSpurningSemErSvorud = fxSvaradarSpurningar.getItems();
                //valinSpurningSemErSvorud.add(valinSpurning);
                //fxSpurning.setText(valinSpurning);
            }



        public static void main (String[]args){
            Spurningar spurningar = new Spurningar();
            System.out.println(spurningar.getSpurningalisti("Færnispurningar").get(1));
            System.out.println(spurningar.getSpurningalisti("Tæknispurningar").get(0));
            System.out.println(spurningar.getFlokkar());
            System.out.println(spurningar.getFjoldiSvaradraSpurninga());
        }

    }
