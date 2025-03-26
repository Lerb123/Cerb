/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceos.phoebus.runtime.editorreceta;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;

/**
 *
 * @author ceos
 */

public class Registro {
    private StringProperty nombreFase;
    private BooleanProperty chk1, chk2, chk3, chk4, chk5, chk6, chk7, chk8, chk9, chk10;

    public Registro(String nombreFase) {
     this.nombreFase=new SimpleStringProperty(nombreFase);
     this.chk1= new SimpleBooleanProperty(false);
     this.chk2= new SimpleBooleanProperty(false);
     this.chk3= new SimpleBooleanProperty(false);
     this.chk4= new SimpleBooleanProperty(false);
     this.chk5= new SimpleBooleanProperty(false);
     this.chk6= new SimpleBooleanProperty(false);
     this.chk7= new SimpleBooleanProperty(false);
     this.chk8= new SimpleBooleanProperty(false);
     this.chk9= new SimpleBooleanProperty(false);
     this.chk10= new SimpleBooleanProperty(false);
    }

    public void setNombreFase(String nombreFase) {
        this.nombreFase.set(nombreFase);
    }

    public void setChk1(boolean chk1) {
        this.chk1.set(chk1);
    }

    public void setChk2(boolean chk2) {
        this.chk2.set(chk2);
    }

    public void setChk3(boolean chk3) {
        this.chk3.set(chk3);
    }

    public void setChk4(boolean chk4) {
        this.chk4.set(chk4);
    }

    public void setChk5(boolean chk5) {
        this.chk5.set(chk5);
    }

    public void setChk6(boolean chk6) {
        this.chk6.set(chk6);
    }

    public void setChk7(boolean chk7) {
        this.chk7.set(chk7);
    }

    public void setChk8(boolean chk8) {
        this.chk8.set(chk8);
    }

    public void setChk9(boolean chk9) {
        this.chk9.set(chk9);
    }

    public void setChk10(boolean chk10) {
        this.chk10.set(chk10);
    }

    public String getNombreFase() {
        return nombreFase.get();
    }

    public boolean getChk1() {
        return chk1.get();
    }

    public boolean getChk2() {
        return chk2.get();
    }

    public boolean getChk3() {
        return chk3.get();
    }

    public boolean getChk4() {
        return chk4.get();
    }

    public boolean getChk5() {
        return chk5.get();
    }

    public boolean getChk6() {
        return chk6.get();
    }

    public boolean getChk7() {
        return chk7.get();
    }

    public boolean getChk8() {
        return chk8.get();
    }

    public boolean getChk9() {
        return chk9.get();
    }

    public boolean getChk10() {
        return chk10.get();
    }

    
    
}
