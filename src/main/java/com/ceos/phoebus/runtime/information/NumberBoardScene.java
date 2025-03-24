package com.ceos.phoebus.runtime.information;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class NumberBoardScene {

    private GridPane root;
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
    private static  Button bAcep = new Button("Accept");

    public NumberBoardScene() {
        root = new GridPane();
        root.setMinSize(100, 100);
        root.setPadding(new Insets(5, 5, 5, 5));
        root.setVgap(5);
        root.setHgap(5);

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

        /*
        Add controls GridPane
         */
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

    }

    public GridPane getRoot() {
        return root;
    }

    public static Button getbAcep() {
        return bAcep;
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
}
