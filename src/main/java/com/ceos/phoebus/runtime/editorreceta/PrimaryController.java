/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.ceos.phoebus.runtime.editorreceta;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author ceos
 */
public class PrimaryController implements Initializable {

    ObservableList<String> products = FXCollections.observableArrayList("Frescolita 2L", "Chinotto 2L",
            "Chinotto 1.5L", "Coca-Cola 1.5L", "Producto Sc", "Coca-Cola Light 2L",
            "Coca-Cola 2L", "Grapette Naranja 1.5", "CocaCola m-c1.25L", "CocaCola 350ml",
            "Grapette Uva 1.5L");
    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ComboBox productsBox;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productsBox.setValue("Coca-Cola 2L");
        productsBox.setItems(products);
    }    
    
}
