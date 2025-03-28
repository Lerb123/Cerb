/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.ceos.phoebus.runtime.editorreceta;

import com.ceos.phoebus.runtime.CeosUtils;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    private TextField numberRecipe;
    @FXML
    private TextField brixsyrup;
    @FXML
    private TextField specificWeight;
    @FXML
    private TextField brixBeverage;
    @FXML
    private TextField nominalRatio;
    @FXML
    private TextField co2Volumes;
    @FXML
    private TextField saturatorPressure;
    @FXML
    private TextField beverageTemperature;
    @FXML
    private TextField nominalProduction;
    @FXML
    private TextField minNivel;
    @FXML
    private Label vm1;
    @FXML
    private Label vm2;
    @FXML
    private Label vm3;

     @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    miComboBox.setValue("Coca-Cola Menos Calorías 2L");
    }
    
    @FXML
    public void handleValueAction() {
        double syrupBrix = 0, drinkBrix = 0;
        int recipeNumber, vm_1, vm_2, vm_3;
        double specificWeightSyrup, nominalratio, co2Volume, saturatorpressure, temperatureDrinking, nominalproduction, minLevel;
        //activa y llena los datos de la receta en los fields
        //consulta de seleecion partiendo del valor actual del combobox
        Connection con = CeosUtils.getConnection();
        System.out.println("voy aqui");
        try {
           
            String seleccion = miComboBox.getValue();
            String query = "SELECT * FROM receta WHERE nameproduct='" + seleccion + "';";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {

                if (rs.getString("type").equalsIgnoreCase("brix")) {
                    syrupBrix = rs.getDouble("syrupbrix");
                    drinkBrix = rs.getDouble("drinkbrix");
                }
                recipeNumber = rs.getInt("recipenumber");

                specificWeightSyrup = rs.getDouble("specificweightsyrup");

                nominalratio = rs.getDouble("nominalratio");
                co2Volume = rs.getDouble("co2volume");
                saturatorpressure = rs.getDouble("saturatorpressure");
                temperatureDrinking = rs.getDouble("temperaturedrinking");
                nominalproduction = rs.getDouble("nominalproduction");
                minLevel = rs.getDouble("minLevel");
                vm_1 = rs.getInt("vm1");
                vm_2 = rs.getInt("vm2");
                vm_3 = rs.getInt("vm3");

                System.out.println(co2Volume);
                //asignar valores
                numberRecipe.setText(String.valueOf(recipeNumber));
                brixsyrup.setText(String.valueOf(syrupBrix));
                specificWeight.setText(String.valueOf(specificWeightSyrup));
                brixBeverage.setText(String.valueOf(drinkBrix));
                nominalRatio.setText(String.valueOf(nominalratio));
                co2Volumes.setText(String.valueOf(co2Volume));
                saturatorPressure.setText(String.valueOf(saturatorpressure));
                beverageTemperature.setText(String.valueOf(temperatureDrinking));
                nominalProduction.setText(String.valueOf(nominalproduction));
                minNivel.setText(String.valueOf(minLevel));
                vm1.setText(String.valueOf(vm_1));
                vm2.setText(String.valueOf(vm_2));
                vm3.setText(String.valueOf(vm_3));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    public void handleButton1Action(ActionEvent event) {
        //logic
    }

    @FXML
    public void handleButton2Action(ActionEvent event) {
        //logic
    }

    @FXML
    public void handleButton3Action(ActionEvent event) {
        //logic
    }

    @FXML
    public void handleButton4Action(ActionEvent event) {
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



    @FXML
    private void handleFillMsgAdv() {
        //logic
    }
}
