/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.ceos.phoebus.runtime.editorreceta;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author ceos
 */
public class PrimaryController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ComboBox<String> miComboBox;
    @FXML
    private Label actualRecipe;
    @FXML
    private CheckBox proportion;
    @FXML
    private CheckBox brix;
    @FXML
    private CheckBox diet;

    @FXML

    public void handleValueAction() {
        String seleccion = miComboBox.getValue();
        actualRecipe.setText(seleccion);
    }

    @FXML
    public void handleButton1Action() {
        //logic
    }

    @FXML
    public void handleButton2Action() {
        //logic
    }

    @FXML
    public void handleButton3Action() {
        //logic
    }

    @FXML
    public void handleButton4Action() {
        //logic
    }

    @FXML
    public void handleProportion() {
        if (proportion.isSelected()) {
            brix.setSelected(false);
            diet.setSelected(false);

            //more logic
        }
    }

    @FXML
    public void handleBrix() {
        if (brix.isSelected()) {
            proportion.setSelected(false);
            diet.setSelected(false);

            //more logic
        }
    }

    @FXML
    private void handleDiet() {
        if (diet.isSelected()) {
            proportion.setSelected(false);
            brix.setSelected(false);

            //more logic
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleFillMsgAdv() {
        //logic
    }
}
