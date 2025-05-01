/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.ceos.phoebus.runtime.editorreceta;

import com.ceos.phoebus.runtime.CeosUtils;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.config.Configurator;

/**
 * FXML Controller class
 *
 * @author ceos
 */
public class PrimaryController implements Initializable {
 
    /**
     * Initializes the controller class.
     */
    private ObservableList<String> products = FXCollections.observableArrayList("Coca-Cola Menos Calorías 2L", "Coca-Cola Menos Calorías 1.5L o 1L",
            "Chinotto Sin Calorías 2L", "Chinotto Sin Calorías 1.5L o 1L", "Frescolita Sin Calorías  2L",
            "Frescolita Sin Calorías 1.5L o 1L", "Hit Uva Sin Calorías 2L",
            "Hit Uva Sin Calorías 1.5L o 1L", "Fanta Naranja 2L", "Fanta Naranja 1.5L o 1L");
    @FXML
    private ComboBox<String> miComboBox;
    @FXML
    private Label actualRecipe;
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

    @FXML
    private Button bMenu;
    @FXML
    private Button bLoadPLC;
    @FXML
    private Button bSaveRecipe;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        miComboBox.setItems(products);
//      Configurator.initialize("ceos", "/log4j2.properties");
//        logger.info("The recipe editor has been started");
    }

    /*
    Invoke the template loaded in the database for recipes with default values
     */
    @FXML
    public void handleValueAction() {
        actualRecipe.setText(miComboBox.getValue());
        if (!products.contains(miComboBox.getValue())) {
            products.add(miComboBox.getValue());
        }
        double syrupBrix = 0, drinkBrix = 0;
        int recipeNumber, vm_1, vm_2, vm_3;
        double specificWeightSyrup, nominalratio, co2Volume, saturatorpressure, temperatureDrinking, nominalproduction, minLevel;

        /*
        Connection to sqlite database “ccbna.db”.
         */
        Connection con = CeosUtils.getConnection();

        try {

            String seleccion = miComboBox.getValue();
            String query = "SELECT * FROM receta WHERE nameproduct='" + seleccion + "';";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
//            logger.info(String.format("The recipe has been selected: %s", miComboBox.getValue()));
            
            while (rs.next()) {

                if (rs.getString("type").equalsIgnoreCase("brix")) {
                    syrupBrix = rs.getDouble("syrupbrix");
                    drinkBrix = rs.getDouble("drinkbrix");
                    diet.setSelected(false);
                    brix.setSelected(true);
                    handleBrix();
                }
                if (rs.getString("type").equalsIgnoreCase("diet")) {
                    diet.setSelected(true);
                    brix.setSelected(false);
                    handleDiet();
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
        if (!isProduct(miComboBox.getValue())) {
            System.out.println("producto no esta ");
            String sql = "INSERT INTO receta(recipenumber,syrupbrix,specificweightsyrup,drinkbrix,"
                    + "nominalratio,co2volume,saturatorpressure,temperaturedrinking,nominalproduction,"
                    + "minLevel,vm1,vm2,vm3,nameproduct,type) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

            try (Connection conn = CeosUtils.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

                // Set values
                pstmt.setInt(1, countRegistryProducts());

                if (brix.isSelected()) {
                    pstmt.setDouble(2, Double.parseDouble(brixsyrup.getText()));
                    pstmt.setDouble(4, Double.parseDouble(brixBeverage.getText()));
                    pstmt.setString(15, "brix");
                } else {
                    pstmt.setDouble(2, Double.parseDouble("0"));
                    pstmt.setDouble(4, Double.parseDouble("0"));
                    pstmt.setString(15, "diet");
                }

                pstmt.setDouble(3, Double.parseDouble(specificWeight.getText()));
                pstmt.setDouble(5, Double.parseDouble(nominalRatio.getText()));
                pstmt.setDouble(6, Double.parseDouble(co2Volumes.getText()));
                pstmt.setDouble(7, Double.parseDouble(saturatorPressure.getText()));
                pstmt.setDouble(8, Double.parseDouble(beverageTemperature.getText()));
                pstmt.setDouble(9, Double.parseDouble(nominalProduction.getText()));
                pstmt.setDouble(10, Double.parseDouble(minNivel.getText()));
                // vm1 , vm2, vm3
                pstmt.setInt(11, 0);
                pstmt.setInt(12, 32);
                pstmt.setInt(13, 60);
                pstmt.setString(14, miComboBox.getValue());

                // execute query
                pstmt.executeUpdate();

            } catch (SQLException e) {
                System.out.println("Error al insertar: " + e.getMessage());
            }

        }

    }

    /*
    Load values to PLC 
     */
    @FXML
    public void handleButton2Action(ActionEvent event) {
        //logic
    }

    /*
    Transfer new recipe values to the database "ccbna"
     */
    @FXML
    public void handleButton3Action(ActionEvent event) {
        //logic

    }

    private int countRegistryProducts() {
        String table = "receta";
        String sql = "SELECT COUNT(*) AS total FROM " + table;
        int numberRegistry = 0;

        try (Connection conn = CeosUtils.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                numberRegistry = rs.getInt("total");
            }

        } catch (SQLException ex) {
            System.out.println("Error when counting records: " + ex.getMessage());
        }

        return numberRegistry + 1;
    }

    private boolean isProduct(String value) {
        String sql = "SELECT * FROM receta WHERE nameproduct='" + value + "';";
        try (Connection conn = CeosUtils.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.getString("nameproduct") == null) {
                return false;
            }

        } catch (SQLException ex) {
            System.out.println("Error: No exist " + ex.getMessage());
        }

        return true;
    }

    @FXML
    public void handleButton4Action(ActionEvent event) {
        // validar si debe o no existir este boton, probablemente NO
    }

    @FXML
    public void handleBrix() {
        brixsyrup.setVisible(true);
        brixBeverage.setVisible(true);
        if (brix.isSelected()) {
            diet.setSelected(false);

            //more logic
        }
    }

    @FXML
    private void handleDiet() {
        if (diet.isSelected()) {
            brix.setSelected(false);

            //more logic
            brixsyrup.setVisible(false);
            brixBeverage.setVisible(false);
        }
    }

    @FXML
    private void handleFillMsgAdv() {
        //logic
    }
}
