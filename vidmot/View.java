package com.example.vidmot;
/******************************************************************************
 *  Nafn    : Kristín Sesselja Róbertsdóttir
 *  T-póstur: ksr11@hi.is
 *  Viðmótsforritun 2025
 *
 *  View - nöfn á fxml skrám
 *****************************************************************************/


public enum View {


    VELKOMINN("velkominn-view.fxml"),
    SPURNINGAR("spurningar-view.fxml"),
    //SVAR("svar-view.fxml"),
    KVEDJA("kvedja.view.fxml");

    private final String fileName;

    /**
     *
     * @param fileName
     */
    View(String fileName) {
        this.fileName = fileName;
    }

    /**
     *
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }
}
