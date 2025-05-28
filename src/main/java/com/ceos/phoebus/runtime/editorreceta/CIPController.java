
package com.ceos.phoebus.runtime.editorreceta;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author ceos
 */
public class CIPController implements Initializable {

    @FXML
    private ComboBox<String> comboNP;
    
    @FXML
    private ComboBox<String> comboLP;
    
    @FXML
    private ComboBox<String> comboPS;
    
    @FXML
    private TextField actualValue;

    private String[] values1 = {"Enjuague simple", "CIP con soda", "Desinfectante", "Enjuague desde sala", "CIP Soda fria", "CIP Acido", "CIP 7", "5 pasos", "3 pasos", "CIP"};
    private String[] values2 = {"Enjuague caliente", "Enjuague frio", "Lavaje con soda 80 C", "Cloro", "Lavaggio acido", "Drenaje",
        "Enjuague simple", "Desinfectante con C", "Lavaggio acido C", "Enjuague desde sala i", "Llenar tanque desde", "Llenar tanques", "Test", "Desinfectante", "CIP Soda fria"};

    private List programName;
    private List programSimple;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        programName = Arrays.asList(values1);
        comboNP.getItems().addAll(programName);
        
        programSimple = Arrays.asList(values2);
        comboPS.getItems().addAll(programSimple);
        

    }

    @FXML
    public void handleValueAction() {
        String seleccion = comboNP.getValue();
        actualValue.setText(seleccion);
    }

    @FXML
    public void handleValueActionProgramName() {
        if (comboNP.getItems().contains(actualValue.getText())) {
            comboNP.setValue(actualValue.getText());
        }
    }

    @FXML
    public void handleValueActionProgramList() {

    }

    @FXML
    public void handleValueActionProgramSimple() {

    }

    @FXML
    public void handleBtn1() {

    }

    @FXML
    public void handleBtn2() {

    }

    @FXML
    public void handleBtn3() {

    }

    @FXML
    public void handleBtn4() {

    }

    @FXML
    public void handleBtn5() {

    }
}
