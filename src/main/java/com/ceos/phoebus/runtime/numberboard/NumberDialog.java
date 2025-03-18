/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceos.phoebus.runtime.numberboard;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.csstudio.display.builder.model.Widget;
import org.csstudio.display.builder.runtime.script.ScriptUtil;
import org.phoebus.pv.PV;

/**
 *
 * @author ceos
 */
public class NumberDialog extends Dialog <String>{

    private TextField field = new TextField();
    private Button b0 = new Button("0");
    private Button b1 = new Button("1");
    private Button b2 = new Button("2");
    private Button b3 = new Button("3");
    private Button b4 = new Button("4");
    private Button b5 = new Button("5");
    private Button b6 = new Button("6");
    private Button b7 = new Button("7");
    private Button b8 = new Button("8");
    private Button b9 = new Button("9");
    private Button bClrOne = new Button("Clr");
    private Button bDelete = new Button("Del");
    private Button bPunto = new Button(".");
    private static  Button bAcep = new Button("Enter");

    public NumberDialog(Widget widget) {

        final DialogPane pane = getDialogPane();
        HBox.setHgrow(field, Priority.ALWAYS);
        
//        Node[] nodes = new Node[15];
//
//        nodes[0] = field;
//        nodes[1] = b0;
//        nodes[2] = b1;
//        nodes[3] = b2;
//        nodes[4] = b3;
//        nodes[5] = b4;
//        nodes[6] = b5;
//        nodes[7] = b6;
//        nodes[8] = b7;
//        nodes[9] = b8;
//        nodes[10] = b9;
//        nodes[11] = bClrOne;
//        nodes[12] = bDelete;
//        nodes[13] = bPunto;
//        nodes[14] = bAcep;
        
        GridPane root = new GridPane();
        root.add(field, 0, 0, 4, 1);
        root.add(b9, 0, 1);
        root.add(b8, 1, 1);
        root.add(b7, 2, 1);
        root.add(bClrOne, 3, 1);
        root.add(b6, 0, 2);
        root.add(b5, 1, 2);
        root.add(b4, 2, 2);
        root.add(bDelete, 3, 2);
        root.add(b3, 0, 3);
        root.add(b2, 1, 3);
        root.add(b1, 2, 3);
        root.add(bPunto, 3, 3);
        root.add(b0, 0, 4);
        root.add(bAcep, 1, 4, 4, 1);

        this.setDialogPane(pane);
          /*
        Actions buttons
         */
        b0.setOnMouseClicked(event -> field.setText(field.getText() + b0.getText()));
        b1.setOnMouseClicked(event -> field.setText(field.getText() + b1.getText()));
        b2.setOnMouseClicked(event -> field.setText(field.getText() + b2.getText()));
        b3.setOnMouseClicked(event -> field.setText(field.getText() + b3.getText()));
        b4.setOnMouseClicked(event -> field.setText(field.getText() + b4.getText()));
        b5.setOnMouseClicked(event -> field.setText(field.getText() + b5.getText()));
        b6.setOnMouseClicked(event -> field.setText(field.getText() + b6.getText()));
        b7.setOnMouseClicked(event -> field.setText(field.getText() + b7.getText()));
        b8.setOnMouseClicked(event -> field.setText(field.getText() + b8.getText()));
        b9.setOnMouseClicked(event -> field.setText(field.getText() + b9.getText()));

        bClrOne.setOnMouseClicked((MouseEvent event) -> {
            if (!field.getText().isEmpty()) {
                field.setText(field.getText().substring(0, field.getText().length() - 1));
            }
        });

        bDelete.setOnMouseClicked((MouseEvent event) -> {
            if (!field.getText().isEmpty()) {
                field.clear();
            }
        });

        bPunto.setOnMouseClicked((MouseEvent event) -> {
            if (!field.getText().contains(".")) {
                field.setText(field.getText() + ".");
                System.out.println(stringValidate(field.getText()));
            }
        });
        
         bAcep.setOnMouseClicked((event) -> {
            try {
                this.getDialogPane().getScene().getWindow().setOnCloseRequest(e -> this.close());
                PV pv =  ScriptUtil.getPrimaryPV(widget).getPV();
                
                if (!field.getText().isBlank()) {
                    pv.write(Double.parseDouble(field.getText()));
                }
                
                field.setText("");
            } catch (Exception ex) {
                System.out.println("No se pudo obtener ni escribir en el pv");
            }
        });
        
       
       // pane.setContent(new VBox(15, nodes));
    pane.setContent(new VBox(root));
       
        pane.setMinSize(150, 170);
        setResizable(true);

    }
    
     public boolean stringValidate(String value) {

        boolean checkValue = false;

        String regex = "^\\d+\\.\\d{1,2}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);

        if (matcher.matches()) {
            checkValue = true;
        }

        return checkValue;
    }

    public static  Button getbAcep() {
        return bAcep;
    }

     
}
