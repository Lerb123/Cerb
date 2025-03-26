/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceos.phoebus.runtime.editorreceta;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author ceos
 */
public class ProgramController implements Initializable {

    @FXML
    private ComboBox<String> miComboBox;
    @FXML
    private TableView<Registro> tablePhase;

    @FXML
    private TableColumn col1;
    @FXML
    private TableColumn col2;
    @FXML
    private TableColumn col3;
    @FXML
    private TableColumn col4;
    @FXML
    private TableColumn col5;
    @FXML
    private TableColumn col6;
    @FXML
    private TableColumn col7;
    @FXML
    private TableColumn col8;
    @FXML
    private TableColumn col9;
    @FXML
    private TableColumn col10;

    @FXML
    private TableColumn col11;

    private ObservableList<Registro> registros = FXCollections.observableArrayList(
    new Registro("fase 1")
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        col1.setCellValueFactory(new PropertyValueFactory<Registro, String>("nombreFase"));

        col2.setCellValueFactory(new PropertyValueFactory<Registro, String>("chk1"));
        col2.setCellFactory(CheckBoxTableCell.forTableColumn(param -> new ReadOnlyBooleanWrapper(true)));
//        col2CheckBoxTableCell.forTableColumn(param -> new ReadOnlyBooleanWrapper(true));

        col3.setCellValueFactory(new PropertyValueFactory<Registro, String>("chk2"));
        col3.setCellFactory(CheckBoxTableCell.forTableColumn(param -> new ReadOnlyBooleanWrapper(true)));

        col4.setCellValueFactory(new PropertyValueFactory<Registro, String>("chk3"));
        col4.setCellFactory(CheckBoxTableCell.forTableColumn(param -> new ReadOnlyBooleanWrapper(true)));

        col5.setCellValueFactory(new PropertyValueFactory<Registro, String>("chk4"));
        col5.setCellFactory(CheckBoxTableCell.forTableColumn(param -> new ReadOnlyBooleanWrapper(true)));

        col6.setCellValueFactory(new PropertyValueFactory<Registro, String>("chk5"));
        col6.setCellFactory(CheckBoxTableCell.forTableColumn(param -> new ReadOnlyBooleanWrapper(true)));

        col7.setCellValueFactory(new PropertyValueFactory<Registro, String>("chk6"));
        col7.setCellFactory(CheckBoxTableCell.forTableColumn(param -> new ReadOnlyBooleanWrapper(true)));

        col8.setCellValueFactory(new PropertyValueFactory<Registro, String>("chk7"));
        col8.setCellFactory(CheckBoxTableCell.forTableColumn(param -> new ReadOnlyBooleanWrapper(true)));

        col9.setCellValueFactory(new PropertyValueFactory<Registro, String>("chk8"));
        col9.setCellFactory(CheckBoxTableCell.forTableColumn(param -> new ReadOnlyBooleanWrapper(true)));

        col10.setCellValueFactory(new PropertyValueFactory<Registro, String>("chk9"));
        col10.setCellFactory(CheckBoxTableCell.forTableColumn(param -> new ReadOnlyBooleanWrapper(true)));

        col11.setCellValueFactory(new PropertyValueFactory<Registro, String>("chk10"));
        col11.setCellFactory(CheckBoxTableCell.forTableColumn(param -> new ReadOnlyBooleanWrapper(true)));
        
        tablePhase.setEditable(true);
        tablePhase.setItems(registros);
    }

}
