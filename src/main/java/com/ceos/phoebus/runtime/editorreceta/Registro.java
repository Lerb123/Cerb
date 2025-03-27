package com.ceos.phoebus.runtime.editorreceta;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;

/**
 *
 * @author ceos
 */

public class Registro {
    private SimpleStringProperty nombreFase;
    private CheckBox chk1, chk2, chk3, chk4, chk5, chk6, chk7, chk8, chk9, chk10;
    
       public Registro(String nombreFase) {
        this.nombreFase = new SimpleStringProperty(nombreFase);
        this.chk1 = new CheckBox();
        this.chk2 = new CheckBox();
        this.chk3 = new CheckBox();
        this.chk4 = new CheckBox();
        this.chk5 = new CheckBox();
        this.chk6 = new CheckBox();
        this.chk7 = new CheckBox();
        this.chk8 = new CheckBox();
        this.chk9 = new CheckBox();
        this.chk10 = new CheckBox();
    }
    
       public boolean isActivechk1(){
       return this.chk1.isSelected();
       }

    public String getNombreFase() {
        return nombreFase.get();
    }

    public void setNombreFase(String nombreFase) {
        this.nombreFase.set(nombreFase);
    }

    public CheckBox getChk1() {
        return chk1;
    }

    public void setChk1(CheckBox chk1) {
        this.chk1 = chk1;
    }

    public CheckBox getChk2() {
        return chk2;
    }

    public void setChk2(CheckBox chk2) {
        this.chk2 = chk2;
    }

    public CheckBox getChk3() {
        return chk3;
    }

    public void setChk3(CheckBox chk3) {
        this.chk3 = chk3;
    }

    public CheckBox getChk4() {
        return chk4;
    }

    public void setChk4(CheckBox chk4) {
        this.chk4 = chk4;
    }

    public CheckBox getChk5() {
        return chk5;
    }

    public void setChk5(CheckBox chk5) {
        this.chk5 = chk5;
    }

    public CheckBox getChk6() {
        return chk6;
    }

    public void setChk6(CheckBox chk6) {
        this.chk6 = chk6;
    }

    public CheckBox getChk7() {
        return chk7;
    }

    public void setChk7(CheckBox chk7) {
        this.chk7 = chk7;
    }

    public CheckBox getChk8() {
        return chk8;
    }

    public void setChk8(CheckBox chk8) {
        this.chk8 = chk8;
    }

    public CheckBox getChk9() {
        return chk9;
    }

    public void setChk9(CheckBox chk9) {
        this.chk9 = chk9;
    }

    public CheckBox getChk10() {
        return chk10;
    }

    public void setChk10(CheckBox chk10) {
        this.chk10 = chk10;
    }
    
}
