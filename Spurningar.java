package vinnsla;
/******************************************************************************
 *  @author Kristín Sesselja Róbertsdóttir
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
    public Spurningar() {

        flokkar.add("Létt");
        flokkar.add("Miðlungs");
        flokkar.add("Erfitt");

        ObservableList<String> flokkur1 = FXCollections.observableArrayList();
        flokkur1.add("Hvaða forritunarmál kanntu?");
        flokkur1.add("Hvaða stýrikerfi hefurðu notað?");
        flokkur1.add("Hvernig hefurðu notað debugger?");
        ObservableList<String> flokkur2 = FXCollections.observableArrayList();
        flokkur2.add("Hverjir eru styrkleikar þínir? ");
        flokkur2.add("Hverju viltu bæta þig í");
        flokkur2.add("Hvar viltu vera eftir fimm ár?");
        ObservableList<String> flokkur3 = FXCollections.observableArrayList();
        flokkur3.add("Hvernig býrðu til gagnagrunn?");
        flokkur3.add("Hvernig vinnur þú með SQL?");
        flokkur3.add("Hvernig notar maður Github?");


        spurningar.put(flokkar.get(0), flokkur1);
        spurningar.put(flokkar.get(1), flokkur2);
        spurningar.put(flokkar.get(2), flokkur3);

    }

    /**
     * Nær í nöfn flokkanna
     *
     * @return flokkar
     */
    public ObservableList<String> getFlokkar() {
        return flokkar;
    }

    /**
     * Nær í spurningar úr flokk
     *
     * @param flokkur
     * @return spurningar
     */
    public ObservableList<String> getSpurningalisti(String flokkur) {
        return spurningar.get(flokkur);
    }


    /**
     * @return fjöldi svaraðra spurninga
     */
    public SimpleStringProperty propertyfjoldiSvaradraSpurninga() {

        return fjoldiSvaradraSpurninga;
    }

    /**
     * Hækkar fjölda spurninga um 1
     */
    public void haekkaFjoldiSpurning() {

        fjoldiSvaradraSpurninga.set((Integer.parseInt(fjoldiSvaradraSpurninga.get()) + 1) + "");
    }


    public static void main(String[] args) {

        Spurningar spurningar = new Spurningar();
        System.out.println("Flokkar: ");
        for (String flokkur : spurningar.getFlokkar()) {
            System.out.println("- " + flokkur);
        }
        System.out.println("\nSpurningar eftir flokkum: ");
        for (String flokkur : spurningar.getFlokkar()) {
            System.out.println(flokkur + ": ");
            for (String question : spurningar.getSpurningalisti(flokkur)) {
                System.out.println("  - " + question);
            }
        }
        System.out.println("\nFjöldi svaraðra spurninga " + spurningar.propertyfjoldiSvaradraSpurninga().get());
        spurningar.haekkaFjoldiSpurning();
        System.out.println("Aftur, fjöldi svaraðra spurninga " + spurningar.propertyfjoldiSvaradraSpurninga().get());
    }
}



