package com.ceos.phoebus.runtime;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javax.swing.JFrame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.csstudio.display.builder.model.Widget;
import org.csstudio.dcom.ceos.phoebus.runtimeisplay.builder.representation.ToolkitRepresentation;
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

/**
 *
 * @author ceos
 */
public class CeosUtils {

    private static final Logger logger = LogManager.getLogger(CeosUtils.class);

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
    public static boolean checkLoginUser() {
        boolean check = false;
        //code here
        return check;
    }

    /*
    Servicio rpc en epics v4 utiza protocolo pvAccess par la comunicación entre clientes y 
    servidores. El servidor expone metodos que pueden ser invocados por un cliente.
     */
    public static PVStructure enablePermission(String username, String password) throws RPCRequestException {
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
            System.out.println("Logeado!!!");
            System.out.println(response);
            pv = response;
        } else {
            System.out.println("credenciales falsas");
        }
//        enabled = response.getBooleanField("value").get();
        rpcClient.destroy();

        //retornarmos el valor del permiso
        return pv;
    }

    //elaborado a modo de prueba. Usar para constatar la libreria
    public static void hola() throws RPCRequestException {
        loadLogger();
        System.out.println("Hola mundo!!!!!");
        logger.info("Log ceos");

    }

    private static void loadLogger() {
        Configurator.initialize("ceos", "/log4j2.properties");
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
            // Ignore
        }
    }

    public static String showPasswordDialog(final Widget widget) {

        try {

            ToolkitRepresentation tk = ToolkitRepresentation.getToolkit(widget.getDisplayModel());
            final Node node = JFXBaseRepresentation.getJFXNode(widget);
            final CompletableFuture<String> done = new CompletableFuture<>();

            tk.execute(()
                    -> {
                final Security dialog = new Security();
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

    public static void getPv(final Widget widget) {
        final RuntimePV rt = ScriptUtil.getPrimaryPV(widget);
        System.out.println(rt);
       PV pv = rt.getPV();
        System.out.println(pv);
    }

}
