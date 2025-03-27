/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceos.phoebus.runtime.editorreceta;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import org.csstudio.display.builder.model.Widget;

/**
 *
 * @author ceos
 */
public class ManiobraCarbonatador extends Dialog<String> {

    public ManiobraCarbonatador(Widget widget) {

        setTitle("Ceos Mixer");
        this.getDialogPane().getScene().getWindow().setOnCloseRequest(e -> this.close());
        final DialogPane pane = getDialogPane();
        Parent root;

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("program.fxml"));
            root = fxmlLoader.load();
            pane.setContent(root);
        } catch (IOException ex) {
            Logger.getLogger(EditorReceta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
