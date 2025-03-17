package com.lerb.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
//        scene = new Scene(loadFXML("primary"), 238, 200);
//        stage.setScene(scene);
//        stage.show();
        TextField field = new TextField();
        Button b0 = new Button("0"); 
        Button b1 = new Button("1");
        Button b2 = new Button("2");
        Button b3 = new Button("3");
        Button b4 = new Button("4");
        Button b5 = new Button("5");
        Button b6 = new Button("6");
        Button b7 = new Button("7");
        Button b8 = new Button("8");
        Button b9 = new Button("9");
        Button bClrOne = new Button("Clr");
        Button bDelete = new Button("Del");
        Button bPunto = new Button(".");
        
        b0.setOnMouseClicked(event -> field.setText(field.getText()+ b0.getText()));
        b1.setOnMouseClicked(event -> field.setText(field.getText()+b1.getText()));
        b2.setOnMouseClicked(event -> field.setText(field.getText()+b2.getText()));
        b3.setOnMouseClicked(event -> field.setText(field.getText()+b3.getText()));
        b4.setOnMouseClicked(event -> field.setText(field.getText()+b4.getText()));
        b5.setOnMouseClicked(event -> field.setText(field.getText()+b5.getText()));
        b6.setOnMouseClicked(event -> field.setText(field.getText()+b6.getText()));
        b7.setOnMouseClicked(event -> field.setText(field.getText()+b7.getText()));
        b8.setOnMouseClicked(event -> field.setText(field.getText()+b8.getText()));
        b9.setOnMouseClicked(event -> field.setText(field.getText()+b9.getText()));
        bClrOne.setOnMouseClicked(event -> field.setText(field.getText().substring(0, field.getText().length()-1)));
        bDelete.setOnMouseClicked(event -> field.clear());
        
        bPunto.setOnMouseClicked((MouseEvent event) -> {
            if (!field.getText().contains(".")) {
                field.setText(field.getText()+".");
            }
        });
               

//        StackPane r = new StackPane(); 
//        HBox root = new HBox(b0, b1, b2, b3, b4, b5, b6, b7, b8, b9);
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(100, 100); 
        gridPane.setPadding(new Insets(5, 5, 5, 5));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        gridPane.add(field, 0, 0, 4, 1);
        gridPane.add(b9, 0, 1);
        gridPane.add(b8, 1, 1);
        gridPane.add(b7, 2, 1);
        gridPane.add(bClrOne, 3, 1);
        gridPane.add(b6, 0, 2);
        gridPane.add(b5, 1, 2);
        gridPane.add(b4, 2, 2);
        gridPane.add(bDelete, 3, 2);
        gridPane.add(b3, 0, 3);
        gridPane.add(b2, 1, 3);
        gridPane.add(b1, 2, 3);
        gridPane.add(bPunto, 3, 3);
        gridPane.add(b0, 0, 4);
        
        Scene sc = new Scene(gridPane);
        stage.setScene(sc);
        stage.show();

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
