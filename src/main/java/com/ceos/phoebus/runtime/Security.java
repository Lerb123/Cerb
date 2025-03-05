/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceos.phoebus.runtime;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.csstudio.display.builder.representation.javafx.Messages;
import org.epics.pvaccess.server.rpc.RPCRequestException;
import org.epics.pvdata.pv.PVStructure;

/**
 *
 * @author ceos
 */
public class Security extends Dialog<String> {

    private final TextField username_entry = new TextField();
    PasswordField pass_entry = new PasswordField();
    private final Label pass_captionR = new Label("User Role");
    private final Label pass_captionP = new Label("User Password");
    private boolean valor= false;
    
    
    public Security() {
        
        final DialogPane pane = getDialogPane();

        this.username_entry.setPromptText("Entry your username");
        this.username_entry.setMaxWidth(Double.MAX_VALUE);

        this.pass_entry.setPromptText("Entry your password");
        this.pass_entry.setMaxWidth(Double.MAX_VALUE);

        HBox.setHgrow(username_entry, Priority.ALWAYS);
        HBox.setHgrow(pass_entry, Priority.ALWAYS);

        Node[] nodes = new Node[4];
        nodes[0] = pass_captionR;
        nodes[1] = username_entry;
        nodes[2] = pass_captionP;
        nodes[3] = pass_entry;

        pane.setContent(new VBox(6, nodes));

        pane.setMinSize(150, 150);
        setResizable(true);

        
        pane.getStyleClass().add("text-input-dialog");
        pane.getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        final Button okButton = (Button) pane.lookupButton(ButtonType.OK);
        okButton.addEventFilter(ActionEvent.ACTION, event
                -> {
            final String username = username_entry.getText();
            final String password = pass_entry.getText();
            
            PVStructure pv = null;
            try {
                pv = CeosUtils.enablePermission(username, password);
            } catch (RPCRequestException ex) {
                Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
            }
            valor=  pv.getBooleanField("value").get();
        });

        setResultConverter((button) ->
        {
            return button.getButtonData() == ButtonBar.ButtonData.OK_DONE ? String.valueOf(valor): null;
        });
//
//        Platform.runLater(() -> pass_entry.requestFocus());
    }

 
}
