/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceos.phoebus.runtime.numberboard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.csstudio.display.builder.model.Widget;
import org.csstudio.display.builder.runtime.script.ScriptUtil;
import org.phoebus.pv.PV;

/**
 *
 * @author ceos
 */
public class NumberDialog extends Dialog<String> {

    private TextField field = new TextField();
    private Button blogo = new Button("◥ ◤");
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
    private Button bClrOne = new Button("Del");
    private Button bDelete = new Button("Clr");
    private Button bPunto = new Button(".");
    private static Button bAcep = new Button("Enter");

    public NumberDialog(Widget widget) {
         this.getDialogPane().getScene().getWindow().setOnCloseRequest(e -> this.close());
        //Sizes
        setSize();
        setFont();
        //Fonts

        final DialogPane pane = getDialogPane();

        GridPane root = new GridPane();
//        root.setPadding(new Insets(0, 0, 0, 15));
        root.setHgap(5);
        root.setVgap(4);

        root.add(field, 0, 0, 7, 1);

        root.add(b9, 0, 2);
        root.add(b8, 2, 2);
        root.add(b7, 4, 2);
        root.add(bClrOne, 6, 2);

        root.add(b6, 0, 3);
        root.add(b5, 2, 3);
        root.add(b4, 4, 3);
        root.add(bDelete, 6, 3);

        root.add(b3, 0, 5);
        root.add(b2, 2, 5);
        root.add(b1, 4, 5);
        root.add(blogo, 6, 5);

        root.add(b0, 0, 7);
        root.add(bPunto, 2, 7);
        root.add(bAcep, 4, 7, 7, 1);
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

        pane.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            public void handle(KeyEvent keyEvent) {

                PV pv = ScriptUtil.getPrimaryPV(widget).getPV();
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    if (!field.getText().isBlank()) {
                        try {

                            pv.write(Double.parseDouble(field.getText()));
                        } catch (Exception ex) {

                        }
                    }
                }

            }
        });

       
        bAcep.setOnMouseClicked((event) -> {
            try {
               
                PV pv = ScriptUtil.getPrimaryPV(widget).getPV();

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

        pane.setMinSize(80, 80);
        setResizable(false);
        pane.setMaxWidth(250);
        pane.setMaxHeight(300);
        

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

    public static Button getbAcep() {
        return bAcep;
    }

    private void setSize() {
        field.setMinHeight(50);
        //sizes buttons
        blogo.setMinWidth(50);
        blogo.setMinHeight(50);
        
        b0.setMinWidth(50);
        b0.setMinHeight(50);

        b1.setMinWidth(50);
        b1.setMinHeight(50);

        b2.setMinWidth(50);
        b2.setMinHeight(50);

        b3.setMinWidth(50);
        b3.setMinHeight(50);

        b4.setMinWidth(50);
        b4.setMinHeight(50);

        b5.setMinWidth(50);
        b5.setMinHeight(50);

        b6.setMinWidth(50);
        b6.setMinHeight(50);

        b7.setMinWidth(50);
        b7.setMinHeight(50);

        b8.setMinWidth(50);
        b8.setMinHeight(50);

        b9.setMinWidth(50);
        b9.setMinHeight(50);

        bClrOne.setMinWidth(50);
        bClrOne.setMinHeight(50);

        bDelete.setMinWidth(50);
        bDelete.setMinHeight(50);

        bPunto.setMinWidth(50);
        bPunto.setMinHeight(50);

        bAcep.setMinWidth(110);
        bAcep.setMinHeight(50);

    }

    private void setFont() {
        Font bFont = Font.font("Arial", FontWeight.BOLD, 15);
        field.setFont(bFont);
        blogo.setFont(bFont);
        b0.setFont(bFont);
        b1.setFont(bFont);
        b2.setFont(bFont);
        b3.setFont(bFont);
        b4.setFont(bFont);
        b5.setFont(bFont);
        b6.setFont(bFont);
        b7.setFont(bFont);
        b8.setFont(bFont);
        b9.setFont(bFont);
        bClrOne.setFont(bFont);
        bDelete.setFont(bFont);
        bPunto.setFont(bFont);
        bAcep.setFont(bFont);
    }
}
