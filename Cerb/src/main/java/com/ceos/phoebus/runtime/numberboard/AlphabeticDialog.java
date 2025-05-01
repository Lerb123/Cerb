/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ceos.phoebus.runtime.numberboard;

import com.ceos.phoebus.runtime.CeosUtils;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import org.csstudio.display.builder.model.Widget;
import org.csstudio.display.builder.runtime.pv.RuntimePV;
import org.csstudio.display.builder.runtime.script.PVUtil;

/**
 *
 * @author Lerb123
 */
public class AlphabeticDialog extends Dialog<String> {

    private final Button btnA = new Button("a");
    private final Button btnB = new Button("b");
    private final Button btnC = new Button("c");
    private final Button btnD = new Button("d");
    private final Button btnE = new Button("e");
    private final Button btnF = new Button("f");
    private final Button btnG = new Button("g");
    private final Button btnH = new Button("h");
    private final Button btnI = new Button("i");
    private final Button btnJ = new Button("j");
    private final Button btnK = new Button("k");
    private final Button btnL = new Button("l");
    private final Button btnM = new Button("m");
    private final Button btnN = new Button("n");
    private final Button btnÑ = new Button("ñ");
    private final Button btnO = new Button("o");
    private final Button btnP = new Button("p");
    private final Button btnQ = new Button("q");
    private final Button btnR = new Button("r");
    private final Button btnS = new Button("s");
    private final Button btnT = new Button("t");
    private final Button btnU = new Button("u");
    private final Button btnV = new Button("v");
    private final Button btnW = new Button("w");
    private final Button btnX = new Button("x");
    private final Button btnY = new Button("y");
    private final Button btnZ = new Button("z");

    private final Button btn0 = new Button("0");
    private final Button btn1 = new Button("1");
    private final Button btn2 = new Button("2");
    private final Button btn3 = new Button("3");
    private final Button btn4 = new Button("4");
    private final Button btn5 = new Button("5");
    private final Button btn6 = new Button("6");
    private final Button btn7 = new Button("7");
    private final Button btn8 = new Button("8");
    private final Button btn9 = new Button("9");

    private final Button bAcep = new Button("Enter");
    private final Button bCancel = new Button("Exit");
    private final Button bClrOne = new Button("Del");
    private final Button bDelete = new Button("Clr");

    private String username;
    private String password;

    public AlphabeticDialog(Widget widget) {
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

        root.add(btnA, 0, 0);
        root.add(btnB, 2, 0);
        root.add(btnC, 4, 0);
        root.add(btnD, 6, 0);
        root.add(btn9, 8, 0);
        root.add(btn8, 10, 0);

        root.add(btnE, 0, 2);
        root.add(btnF, 2, 2);
        root.add(btnG, 4, 2);
        root.add(btnH, 6, 2);
        root.add(btn7, 8, 2);
        root.add(btn6, 10, 2);

        root.add(btnI, 0, 4);
        root.add(btnJ, 2, 4);
        root.add(btnK, 4, 4);
        root.add(btnL, 6, 4);
        root.add(btn5, 8, 4);
        root.add(btn4, 10, 4);

        root.add(btnM, 0, 6);
        root.add(btnN, 2, 6);
        root.add(btnÑ, 4, 6);
        root.add(btnO, 6, 6);
        root.add(btn3, 8, 6);
        root.add(btn2, 10, 6);

        root.add(btnP, 0, 8);
        root.add(btnQ, 2, 8);
        root.add(btnR, 4, 8);
        root.add(btnS, 6, 8);
        root.add(btn1, 8, 8);
        root.add(btn0, 10, 8);

        root.add(btnT, 0, 10);
        root.add(btnU, 2, 10);
        root.add(btnV, 4, 10);
        root.add(btnW, 6, 10);
        root.add(bCancel, 8, 10);
        root.add(bClrOne, 10, 10);

        root.add(btnX, 0, 12);
        root.add(btnY, 2, 12);
        root.add(btnZ, 4, 12);
        root.add(bAcep, 6, 12);
        root.add(bDelete, 8, 12);
        this.setDialogPane(pane);
//        /*
//        Actions buttons
//         */
        btnA.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("a");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "a");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnB.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("b");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "b");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnC.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("c");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "c");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnD.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("d");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "d");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnE.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("e");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "e");

                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnF.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("f");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "f");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnG.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("g");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "g");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnH.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("h");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "h");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnI.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("i");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "i");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnJ.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("j");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "j");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnK.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("k");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "k");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnL.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("l");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "l");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnM.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("m");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "m");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnN.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("n");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "n");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnÑ.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("ñ");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "ñ");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnO.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("o");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "o");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnP.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("p");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "p");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnQ.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("q");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "q");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnR.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("r");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "r");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnS.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("s");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "s");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnT.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("t");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "t");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnU.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("u");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "u");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnV.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("v");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "v");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnW.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("w");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "w");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnX.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("x");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "x");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnY.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("y");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "y");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btnZ.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write("z");

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "z");

                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btn0.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (!"0.0".equals(PVUtil.getString(rpv))) {
                    rpv.getPV().write(PVUtil.getString(rpv) + String.valueOf(0));

                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btn1.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write(String.valueOf(1));

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "1");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btn2.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write(String.valueOf(2));

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "2");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btn3.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write(String.valueOf(3));

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "3");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btn4.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write(String.valueOf(4));

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "4");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btn5.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write(String.valueOf(5));

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "5");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btn6.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write(String.valueOf(6));

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "6");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btn7.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write(String.valueOf(7));

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "7");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btn8.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write(String.valueOf(8));

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "8");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });
        btn9.setOnMouseClicked(event -> {
            try {
                //1.Get runtime pv associated to the widget
                RuntimePV rpv = CeosUtils.getPv(widget);

                //2.Obtain your current value and write it.
                if (PVUtil.getDouble(rpv) == 0.0) {
                    rpv.getPV().write(String.valueOf(9));

                } else {
                    rpv.getPV().write(PVUtil.getString(rpv) + "9");
                }
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Cannot write into pv record" + ex.getMessage());
            }
        });

        bClrOne.setOnMouseClicked((MouseEvent event) -> {
            //1.Get runtime pv associated to the widget
            RuntimePV rpv = CeosUtils.getPv(widget);
            if (!PVUtil.getString(rpv).isEmpty() && PVUtil.getString(rpv).length() > 1) {
                try {
                    rpv.getPV().write(String.valueOf(PVUtil.getString(rpv)).substring(0, PVUtil.getString(rpv).length() - 1));
                } catch (Exception ex) {
                    CeosUtils.getLogger().warn("Ceos-> " + ex.getMessage());
                }

            } else if (String.valueOf(PVUtil.getString(rpv)).length() == 1) {
                try {
                    rpv.getPV().write("");
                } catch (Exception ex) {
                    CeosUtils.getLogger().warn("Ceos-> " + ex.getMessage());
                }
            }
        });

        bDelete.setOnMouseClicked((MouseEvent event) -> {
            //1.Get runtime pv associated to the widget
            RuntimePV rpv = CeosUtils.getPv(widget);

            try {
                rpv.getPV().write("");
            } catch (Exception ex) {
                CeosUtils.getLogger().warn("Ceos-> " + ex.getMessage());
            }
        });

        bAcep.setOnAction((event) -> {
            ((Stage) bAcep.getScene().getWindow()).close();
        });
        // pane.setContent(new VBox(15, nodes));
        pane.setContent(new VBox(root));

        pane.setMinSize(80, 80);
        setResizable(false);
        pane.setMaxWidth(550);
        pane.setMaxHeight(500);

    }

//    public boolean stringValidate(String value) {
//
//        boolean checkValue = false;
//
//        String regex = "^\\d+\\.\\d{1,2}$";
//
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(value);
//
//        if (matcher.matches()) {
//            checkValue = true;
//        }
//
//        return checkValue;
//    }
    private void setSize() {
//        field.setMinHeight(50);
//        //sizes buttons
        btnA.setMinWidth(50);
        btnA.setMinHeight(50);

        btnB.setMinWidth(50);
        btnB.setMinHeight(50);

        btnC.setMinWidth(50);
        btnC.setMinHeight(50);

        btnD.setMinWidth(50);
        btnD.setMinHeight(50);

        btnE.setMinWidth(50);
        btnE.setMinHeight(50);

        btnF.setMinWidth(50);
        btnF.setMinHeight(50);

        btnG.setMinWidth(50);
        btnG.setMinHeight(50);

        btnH.setMinWidth(50);
        btnH.setMinHeight(50);

        btnI.setMinWidth(50);
        btnI.setMinHeight(50);

        btnJ.setMinWidth(50);
        btnJ.setMinHeight(50);

        btnK.setMinWidth(50);
        btnK.setMinHeight(50);

        btnL.setMinWidth(50);
        btnL.setMinHeight(50);

        btnM.setMinWidth(50);
        btnM.setMinHeight(50);

        btnN.setMinWidth(50);
        btnN.setMinHeight(50);

        btnÑ.setMinWidth(50);
        btnÑ.setMinHeight(50);

        btnO.setMinWidth(50);
        btnO.setMinHeight(50);

        btnP.setMinWidth(50);
        btnP.setMinHeight(50);

        btnQ.setMinWidth(50);
        btnQ.setMinHeight(50);

        btnR.setMinWidth(50);
        btnR.setMinHeight(50);

        btnS.setMinWidth(50);
        btnS.setMinHeight(50);

        btnT.setMinWidth(50);
        btnT.setMinHeight(50);

        btnU.setMinWidth(50);
        btnU.setMinHeight(50);

        btnV.setMinWidth(50);
        btnV.setMinHeight(50);

        btnW.setMinWidth(50);
        btnW.setMinHeight(50);

        btnX.setMinWidth(50);
        btnX.setMinHeight(50);

        btnY.setMinWidth(50);
        btnY.setMinHeight(50);

        btnZ.setMinWidth(50);
        btnZ.setMinHeight(50);

        btn0.setMinWidth(50);
        btn0.setMinHeight(50);

        btn1.setMinWidth(50);
        btn1.setMinHeight(50);

        btn2.setMinWidth(50);
        btn2.setMinHeight(50);

        btn3.setMinWidth(50);
        btn3.setMinHeight(50);

        btn4.setMinWidth(50);
        btn4.setMinHeight(50);

        btn5.setMinWidth(50);
        btn5.setMinHeight(50);

        btn6.setMinWidth(50);
        btn6.setMinHeight(50);

        btn7.setMinWidth(50);
        btn7.setMinHeight(50);

        btn8.setMinWidth(50);
        btn8.setMinHeight(50);

        btn9.setMinWidth(50);
        btn9.setMinHeight(50);

        bAcep.setMinWidth(50);
        bAcep.setMinHeight(50);

        bCancel.setMinWidth(50);
        bCancel.setMinHeight(50);

        bClrOne.setMinWidth(50);
        bClrOne.setMinHeight(50);

        bDelete.setMinWidth(50);
        bDelete.setMinHeight(50);
    }

    private void setFont() {
        Font bFont = Font.font("Arial", FontWeight.BOLD, 14);

        btnA.setFont(bFont);
        btnB.setFont(bFont);
        btnC.setFont(bFont);
        btnD.setFont(bFont);
        btnE.setFont(bFont);
        btnF.setFont(bFont);
        btnG.setFont(bFont);
        btnH.setFont(bFont);
        btnI.setFont(bFont);
        btnJ.setFont(bFont);
        btnK.setFont(bFont);
        btnL.setFont(bFont);
        btnM.setFont(bFont);
        btnN.setFont(bFont);
        btnÑ.setFont(bFont);
        btnO.setFont(bFont);
        btnP.setFont(bFont);
        btnQ.setFont(bFont);
        btnR.setFont(bFont);
        btnS.setFont(bFont);
        btnT.setFont(bFont);
        btnU.setFont(bFont);
        btnV.setFont(bFont);
        btnW.setFont(bFont);
        btnX.setFont(bFont);
        btnY.setFont(bFont);
        btnZ.setFont(bFont);
        btn0.setFont(bFont);
        btn1.setFont(bFont);
        btn2.setFont(bFont);
        btn3.setFont(bFont);
        btn4.setFont(bFont);
        btn5.setFont(bFont);
        btn6.setFont(bFont);
        btn7.setFont(bFont);
        btn8.setFont(bFont);
        btn9.setFont(bFont);
        bClrOne.setFont(bFont);
        bDelete.setFont(bFont);
        bAcep.setFont(bFont);
        bCancel.setFont(bFont);

    }
}
