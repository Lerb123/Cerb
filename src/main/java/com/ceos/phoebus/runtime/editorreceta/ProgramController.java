package com.ceos.phoebus.runtime.editorreceta;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    private TableColumn <Registro, String> col1;
    @FXML
    private TableColumn <Registro, CheckBox> col2;
    @FXML
    private TableColumn <Registro, CheckBox> col3;
    @FXML
    private TableColumn <Registro, CheckBox> col4;
    @FXML
    private TableColumn <Registro, CheckBox> col5;
    @FXML
    private TableColumn <Registro, CheckBox> col6;
    @FXML
    private TableColumn <Registro, CheckBox> col7;
    @FXML
    private TableColumn <Registro, CheckBox> col8;
    @FXML
    private TableColumn <Registro, CheckBox> col9;
    @FXML
    private TableColumn <Registro, CheckBox> col10;

    @FXML
    private TableColumn <Registro, CheckBox> col11 ;

    private ObservableList<Registro> registros = FXCollections.observableArrayList(
            new Registro("Calentador"),
            new Registro("EV01 flotador desareador"),
            new Registro("EV02 inundacion desareador"),
            new Registro("EV03 flotador tanque jarabe"),
            new Registro("EV04 inundacion tanque jarabe"),
            new Registro("EV26 inyeccion CO2"),
            new Registro("EV14 descarga desareador"),
            new Registro("EV15 descarga tanque jarabe"),
            new Registro("Descarga llenadora"),
            new Registro("Libre"),
            new Registro("EV23 descarga serpentin"),
            new Registro("libre"),
            new Registro("EV31 Tubos de Venturi"),
            new Registro("EV32 Lavado tubos de Venturi"),
            new Registro("EV33 Aspiracion"),
            new Registro("EV34 Aspiracion desinfectante"),
            new Registro("EV35 Aspiacion acido"),
            new Registro("EV36 Reciclado"),
            new Registro("EV37 Descarga general"),
            new Registro("EV38 Recuperacion soda"),
            new Registro("P1 Bomba agua"),
            new Registro("P2 Bomba sala jarabe"),
            new Registro("Temperatura correcta"),
            new Registro("Conductividad baja"),
            new Registro("Conductividad alta"),
            new Registro("Maximo nivel saturador")
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        col1.setCellValueFactory(new PropertyValueFactory<>("nombreFase"));
//
        col2.setCellValueFactory(new PropertyValueFactory<>("chk1"));
        col3.setCellValueFactory(new PropertyValueFactory<>("chk2"));
        col4.setCellValueFactory(new PropertyValueFactory<>("chk3"));
//
        col5.setCellValueFactory(new PropertyValueFactory<>("chk4"));
//
        col6.setCellValueFactory(new PropertyValueFactory<>("chk5"));
        col7.setCellValueFactory(new PropertyValueFactory<>("chk6"));
//
        col8.setCellValueFactory(new PropertyValueFactory<>("chk7"));
//
        col9.setCellValueFactory(new PropertyValueFactory<>("chk8"));
//
        col10.setCellValueFactory(new PropertyValueFactory<>("chk9"));
//
        col11.setCellValueFactory(new PropertyValueFactory<>("chk10"));

//        col2.setOnEditCommit((t) -> {
//            System.out.println( registros.get(0).isActivechk1());
//            
//        });
      
        tablePhase.setEditable(true);
        tablePhase.setItems(registros);
    }

    @FXML
    public void handleRegistry(){
    
        for (Registro registro : registros) {
            if (registro.getChk1().isSelected()) {
                System.out.println("pum chk1");
                
            }
           if (registro.getChk2().isSelected()) {
                 System.out.println("pum chk2");
                 //logic
            }
           if (registro.getChk3().isSelected()) {
                 System.out.println("pum chk3");
                 //logic
            }
           if (registro.getChk4().isSelected()) {
                 System.out.println("pum chk4");
                 //logic
            }
           if (registro.getChk5().isSelected()) {
                 System.out.println("pum chk5");
                 //logic
            }
           if (registro.getChk6().isSelected()) {
                 System.out.println("pum chk6");
                 //logic
                 
            }
           if (registro.getChk7().isSelected()) {
                System.out.println("pum chk7");
                //logic
            }
           if (registro.getChk8().isSelected()) {
                 System.out.println("pum chk8");
                 //logic
            }
           if (registro.getChk9().isSelected()) {
                 System.out.println("pum chk9");
                 //logic
            }
            if (registro.getChk10().isSelected()) {
                 System.out.println("pum chk10");
                 //logic
            }
           
        }
    }
}
