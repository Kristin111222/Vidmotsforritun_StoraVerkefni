package vinnsla;
/******************************************************************************
 *  Nafn    : Kristín Sesselja Róbertsdóttir
 *  T-póstur: ksr11@hi.is
 *  Viðmótsforritun 2025
 *
 *  Spurningar
 *
 *  -- heldur utan um fjölda svaraðra spurninga
 *  -- nöfn flokka og spurningalista
 *****************************************************************************/

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.HashMap;
import java.util.Map;

public class Spurningar {

    private final ObservableList<String> flokkar = FXCollections.observableArrayList();
    private final Map<String, ObservableList<String>> spurningar = new HashMap<>();
    private final SimpleStringProperty fjoldiSvaradraSpurninga = new SimpleStringProperty("0");


    /**
     * Spurningar, flokkar settir
     * spurningar búnar til fyrir hvern flokk
     */
    public Spurningar() { // 3-5 spurningar

        flokkar.add("Tæknispurningar");
        flokkar.add("Færnispurningar");

        ObservableList<String> TaekniSpurningar = FXCollections.observableArrayList(
                "Kanntu á Excel?", "Kanntu Java?", "Kanntu á Reiknivél?"
        );

        ObservableList<String> FaerniniSpurningar = FXCollections.observableArrayList(
                "Ertu með vinnuvélapróf?", "Ertu með bílpróf?", "Ertu í Hugbúnaðarverkfræði?"
        );

        spurningar.put("Tæknispurningar", TaekniSpurningar);
        spurningar.put("Færnispurningar", FaerniniSpurningar);

    }

    /**
     * Nær í nöfn flokkanna
     * @return flokkar
     */
        public ObservableList<String> getFlokkar() {
            return flokkar;
        }

    /**
     * Nær í spurningar úr flokk
     * @param flokkur
     * @return spurningar
     */
        public ObservableList<String> getSpurningalisti(String flokkur){
            return spurningar.get(flokkur);
        }

    /**
     * Teljari fyrir fjölda svaraðra spurninga
     */
    //public void fjoldiSvaradraSpurninga(){
           // int samtals = Integer.parseInt(fjoldiSvaradraSpurninga.get());
            //samtals += 1; //nýtt
            //fjoldiSvaradraSpurninga.set(String.valueOf(samtals)); //eyddi út +1
        //}

    /**
     *
     * @return fjöldi svaraðra spurninga
     */
        public String getFjoldiSvaradraSpurninga() {
        return fjoldiSvaradraSpurninga.get();
    }

   /*
    public SvarDialogController(String selectedItem) {
        setDialogPane(lesaSvarDialog());
    }

    */


    public static void main(String[] args) {
                Spurningar spurningar = new Spurningar();
                System.out.println (spurningar.getSpurningalisti("Færnispurningar").get(1));
                System.out.println (spurningar.getSpurningalisti("Tæknispurningar").get(0));
                System.out.println (spurningar.getFlokkar());
                System.out.println (spurningar.getFjoldiSvaradraSpurninga());
        }

    public void haekkaFjoldiSpurning() {
        fjoldiSvaradraSpurninga.setValue(fjoldiSvaradraSpurninga.get()+1);
    }
}




