package com.ceos.phoebus.runtime;

import com.ceos.phoebus.runtime.editorreceta.EditorReceta;
import com.ceos.phoebus.runtime.editorreceta.ManiobraCarbonatador;
import com.ceos.phoebus.runtime.numberboard.AlphabeticDialog;
import com.ceos.phoebus.runtime.numberboard.NumberDialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import javafx.scene.Node;
import javafx.scene.control.Alert;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.core.config.Configurator;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.csstudio.display.builder.model.Widget;
import org.csstudio.display.builder.representation.ToolkitRepresentation;
import org.csstudio.display.builder.representation.javafx.Messages;
import org.csstudio.display.builder.representation.javafx.widgets.JFXBaseRepresentation;
import org.csstudio.display.builder.runtime.pv.RuntimePV;
import org.csstudio.display.builder.runtime.script.PVUtil;
import org.csstudio.display.builder.runtime.script.ScriptUtil;
import org.epics.pvaccess.client.rpc.RPCClientImpl;
import org.epics.pvaccess.server.rpc.RPCRequestException;
import org.epics.pvdata.factory.FieldFactory;
import org.epics.pvdata.factory.PVDataFactory;
import org.epics.pvdata.pv.FieldCreate;
import org.epics.pvdata.pv.PVStructure;
import org.epics.pvdata.pv.ScalarType;
import org.epics.pvdata.pv.Structure;
import org.phoebus.pv.PV;
import org.phoebus.ui.dialog.DialogHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

/**
 *
 * @author ceos
 */
public class CeosUtils {

    private static final Logger logger = LoggerFactory.getLogger(CeosUtils.class);
//private static final Logger logger =LogManager.getLogger(CeosUtils.class);

    /* 
    public static void main(String[] args) {
        loadLogger();
        System.out.println("Hola mundo!!!!!");
        logger.info("Log ceos");
        try {
            //Estrutura retornada
             System.out.println( CeosUtils.enablePermission("karaf", "karaf"));
            JFrame marco = new JFrame();
            marco.setSize(400, 300);
            marco.setLocation(1500, 1000);
            marco.add(new LoginDialog());
            marco.setVisible(true);
            System.exit(0);
        } catch (Exception e) {

        }
    }
     */
    //
    public static Logger getLogger() {
        return logger;
    }

    /*
    Servicio rpc en epics v4 utiza protocolo pvAccess par la comunicación entre clientes y 
    servidores. El servidor expone metodos que pueden ser invocados por un cliente.
    
    TODO: 
        Remember to activate the JAAS configuration with the command :

        a. jaas:realm-list
        b. jaas:realm-manage --index 1
     */
    public static Boolean handlerLoginUser(String username, String password) throws RPCRequestException {
        PVStructure pv = null;
        boolean enabled = false;
        //hacemos la llamada al punto rpc (_Security) y validamos qu exista el usuario logeado en phoebus
        FieldCreate fieldCreate = FieldFactory.getFieldCreate();
        Structure requestStructure = fieldCreate.createFieldBuilder()
                .add("op", ScalarType.pvString)
                .add("username", ScalarType.pvString)
                .add("query", ScalarType.pvString)
                .createStructure();

        PVStructure request = PVDataFactory.getPVDataCreate().createPVStructure(requestStructure);

        request.getStringField("op").put("login");
        request.getStringField("username").put(username);
        request.getStringField("query").put(password);

        RPCClientImpl rpcClient = new RPCClientImpl("_Security");

        PVStructure response = rpcClient.request(request, 3.0);

        if (response != null) {
            pv = response;
        }

        rpcClient.destroy();
        if (pv.getBooleanField("value").get()) {
            enabled = checkLoginUser(username, password);
        }

        //retornarmos el valor del permiso
        return enabled;
    }

    //Invocado por handlerLoginUser
    private static boolean checkLoginUser(String username, String password) throws RPCRequestException {
        PVStructure pv = null;
        boolean enabled = false;
        //hacemos la llamada al punto rpc (_Security) y validamos qu exista el usuario logeado en phoebus
        FieldCreate fieldCreate = FieldFactory.getFieldCreate();
        Structure requestStructure = fieldCreate.createFieldBuilder()
                .add("op", ScalarType.pvString)
                .add("username", ScalarType.pvString)
                .add("query", ScalarType.pvString)
                .createStructure();

        PVStructure request = PVDataFactory.getPVDataCreate().createPVStructure(requestStructure);

        request.getStringField("op").put("checklogin");
        request.getStringField("username").put(username);
        request.getStringField("query").put(password);

        RPCClientImpl rpcClient = new RPCClientImpl("_Security");

        PVStructure response = rpcClient.request(request, 3.0);

        if (response != null) {
            pv = response;
        } else {

        }
        rpcClient.destroy();
        enabled = pv.getBooleanField("value").get();
        //retornarmos el valor del permiso
        return enabled;
    }

    public static boolean checkAutoLogoutUser(String username, String password) throws RPCRequestException {
        PVStructure pv = null;
        boolean enabled = false;
        //hacemos la llamada al punto rpc (_Security) y validamos qu exista el usuario logeado en phoebus
        FieldCreate fieldCreate = FieldFactory.getFieldCreate();
        Structure requestStructure = fieldCreate.createFieldBuilder()
                .add("op", ScalarType.pvString)
                .add("username", ScalarType.pvString)
                .add("query", ScalarType.pvString)
                .createStructure();

        PVStructure request = PVDataFactory.getPVDataCreate().createPVStructure(requestStructure);

        request.getStringField("op").put("checkautologout");
        request.getStringField("username").put(username);
        request.getStringField("query").put(password);

        RPCClientImpl rpcClient = new RPCClientImpl("_Security");

        PVStructure response = rpcClient.request(request, 3.0);

        if (response != null) {
            pv = response;
        } else {

        }
        rpcClient.destroy();
        enabled = pv.getBooleanField("value").get();
        //retornarmos el valor del permiso
        return enabled;
    }

    public static boolean handlerLogoutUser(String username, String password) throws RPCRequestException {
        PVStructure pv = null;
        boolean enabled = false;
        //hacemos la llamada al punto rpc (_Security) y validamos qu exista el usuario logeado en phoebus
        FieldCreate fieldCreate = FieldFactory.getFieldCreate();
        Structure requestStructure = fieldCreate.createFieldBuilder()
                .add("op", ScalarType.pvString)
                .add("username", ScalarType.pvString)
                .add("query", ScalarType.pvString)
                .createStructure();

        PVStructure request = PVDataFactory.getPVDataCreate().createPVStructure(requestStructure);

        request.getStringField("op").put("logout");
        request.getStringField("username").put(username);
        request.getStringField("query").put(password);

        RPCClientImpl rpcClient = new RPCClientImpl("_Security");

        PVStructure response = rpcClient.request(request, 3.0);

        if (response != null) {
            pv = response;
        } else {

        }
        rpcClient.destroy();
        enabled = pv.getBooleanField("value").get();
        return enabled;

    }

    //elaborado a modo de prueba. Usar para constatar la libreria
    public static void hola() {
//        Configurator.initialize("ceos", "/log4j2.properties");

        System.out.println("Hola mundo!!!!!");
        logger.info("Log ceos");

    }

    public static void showErrorDialog(final Widget widget, final String error) throws Exception {
        final Node node = JFXBaseRepresentation.getJFXNode(widget);
        final CountDownLatch done = new CountDownLatch(1);
        final ToolkitRepresentation tk = ToolkitRepresentation.getToolkit(widget.getDisplayModel());
        try {

            tk.execute(()
                    -> {
                final Alert alert = new Alert(Alert.AlertType.WARNING);
                DialogHelper.positionDialog(alert, node, -100, -50);
                alert.setResizable(true);
                alert.setTitle(Messages.ShowErrorDialogTitle);
                alert.setHeaderText(error);
                alert.initOwner(node.getScene().getWindow());
                alert.showAndWait();
                done.countDown();
            });

        } catch (Exception ex) {

        }
        try {
            done.await();
        } catch (InterruptedException ex) {
            logger.error("error" + ex.getMessage());
        }
    }

    public static String showPasswordDialog(final Widget widget) {

        try {

            ToolkitRepresentation tk = ToolkitRepresentation.getToolkit(widget.getDisplayModel());
            final Node node = JFXBaseRepresentation.getJFXNode(widget);
            final CompletableFuture<String> done = new CompletableFuture<>();

            tk.execute(()
                    -> {
                final Security dialog = new Security(widget);
                DialogHelper.positionDialog(dialog, node, -100, -50);
                dialog.initOwner(node.getScene().getWindow());
                final Optional<String> result = dialog.showAndWait();
                done.complete(result.orElse(null));
            });

            try {

                return done.get();

            } catch (Exception ex) {
                logger.info(ex.getMessage());
            }

            return null;
        } catch (Exception ex) {
            logger.info(ex.getMessage());
        }
        return null;

    }

    public static RuntimePV getPv(final Widget widget) {
        final RuntimePV rt = ScriptUtil.getPrimaryPV(widget);

        PV pv = rt.getPV();

        return rt;
    }

    //
    public static void initNumberBoardScene(final Widget widget) {
        try {
            ToolkitRepresentation tk = ToolkitRepresentation.getToolkit(widget.getDisplayModel());
            final Node node = JFXBaseRepresentation.getJFXNode(widget);

            tk.execute(()
                    -> {
                final NumberDialog dialog = new NumberDialog(widget);
                DialogHelper.positionDialog(dialog, node, -100, -50);
//                 final TecladoAlfabetico teclado = new TecladoAlfabetico(widget);
//                DialogHelper.positionDialog(teclado, node, -100, -50);
                dialog.initOwner(node.getScene().getWindow());
//                teclado.initOwner(node.getScene().getWindow());
                dialog.show();
//                teclado.show();
            });
        } catch (Exception ex) {
            logger.error("error" + ex.getMessage());
        }

        /*NO BORRAR
        Init toolkit de javafx
          Platform.startup(()
                -> {
        });
         */
    }

    public static void initAlphabeticBoardScene(final Widget widget) {
        try {
            ToolkitRepresentation tk = ToolkitRepresentation.getToolkit(widget.getDisplayModel());
            final Node node = JFXBaseRepresentation.getJFXNode(widget);

            tk.execute(()
                    -> {
                final AlphabeticDialog dialog = new AlphabeticDialog(widget);
                DialogHelper.positionDialog(dialog, node, -100, -50);
//                 final TecladoAlfabetico teclado = new TecladoAlfabetico(widget);
//                DialogHelper.positionDialog(teclado, node, -100, -50);
                dialog.initOwner(node.getScene().getWindow());
//                teclado.initOwner(node.getScene().getWindow());
                dialog.show();
//                teclado.show();
            });
        } catch (Exception ex) {
            logger.error("error" + ex.getMessage());
        }

        /*NO BORRAR
        Init toolkit de javafx
          Platform.startup(()
                -> {
        });
         */
    }

    public static void initEditorRecipe(final Widget widget) {
        try {
            ToolkitRepresentation tk = ToolkitRepresentation.getToolkit(widget.getDisplayModel());
            final Node node = JFXBaseRepresentation.getJFXNode(widget);

            tk.execute(()
                    -> {
                final EditorReceta dialog = new EditorReceta(widget);

                DialogHelper.positionDialog(dialog, node, -100, -50);

                dialog.initOwner(node.getScene().getWindow());

                dialog.show();
            });
        } catch (Exception ex) {
            logger.error("error" + ex.getMessage());
        }

    }

    public static void initManeuver(final Widget widget) {
        try {
            ToolkitRepresentation tk = ToolkitRepresentation.getToolkit(widget.getDisplayModel());
            final Node node = JFXBaseRepresentation.getJFXNode(widget);

            tk.execute(()
                    -> {
                final ManiobraCarbonatador dialog = new ManiobraCarbonatador(widget);
                DialogHelper.positionDialog(dialog, node, -100, -50);
                dialog.initOwner(node.getScene().getWindow());
                dialog.show();
            });
        } catch (Exception ex) {
            logger.error("error" + ex.getMessage());
        }

    }

    public static Connection getConnection() {

        final String URL = "jdbc:sqlite:ccbna.db";
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL);
            System.out.println("conectado");
        } catch (SQLException ex) {
            System.err.println("no conectado");
        }

        return con;
    }

    /**
     *
     * @param nameR, name of the recipe to be searched in the database
     *
     */
    public static void setRecipeFromDB(String nameR) {

        try {
            /*
            Connection to sqlite database “ccbna.db”.
             */
            Connection con = CeosUtils.getConnection();
            System.out.println(nameR);
            
            String query = "SELECT * FROM receta WHERE nameproduct= ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, nameR);
            
             ResultSet rs = preparedStatement.executeQuery();
             
             //TODO: guardar ultimas modificaciones de los valores de la receta.
             //TODO: Ingresar al log
          
            while (rs.next()) {
                
                try {
                    
                    PVUtil.writePV("pva://fbEM_Main_DB_PARAMS_ProductionData_rBrixSyrup/value", rs.getDouble("syrupbrix"), 1000);
                    PVUtil.writePV("pva://fbEM_Main_DB_PARAMS_ProductionData_rSWSyrup/value", rs.getDouble("specificweightsyrup"), 1000);
                    PVUtil.writePV("pva://fbEM_Main_DB_PARAMS_ProductionData_rBrixBeberage/value", rs.getDouble("drinkbrix"), 1000);
                    PVUtil.writePV("pva://fbEM_Main_DB_PARAMS_ProductionData_rNominalRelatioin/value", rs.getDouble("nominalratio"), 1000);
                    PVUtil.writePV("pva://fbEM_Main_DB_PARAMS_ProductionData_rCO2Vol/value", rs.getDouble("co2volume"), 1000);
                    PVUtil.writePV("pva://fbEM_Main_DB_PARAMS_ProductionData_rPressStorage/value", rs.getDouble("saturatorpressure"), 1000);
                    PVUtil.writePV("pva://fbEM_Main_DB_PARAMS_ProductionData_rTempBeberage/value", rs.getDouble("temperaturedrinking"), 1000);
                    PVUtil.writePV("pva://fbEM_Main_DB_PARAMS_ProductionData_rNominalProduction/value", rs.getDouble("nominalproduction"), 1000);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
//            rs.close();
//            preparedStatement.close();
//            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
