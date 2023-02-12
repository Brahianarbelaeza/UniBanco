package co.uniquindio.application;


import co.uniquindio.controller.Controller;
import co.uniquindio.model.Banco;
import co.uniquindio.model.Cliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class application extends Application {
    private Banco banco;

    public static void main(String[] args) {

        launch();
    }


    @Override
    public void start(Stage stage) throws Exception {
        banco = new Banco();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Unibanco_view_inicio.fxml"));
        AnchorPane pane = loader.load();
        Controller controller = loader.getController();
        controller.setMain(this);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public void actualizarCliente() {

        banco.actualizarCliente();
    }

    public void crearCliente(Cliente cliente) {
        banco.crearCliente(cliente);
    }

    public ArrayList<Cliente> getListaClientes() {
        return banco.getListaClientes();
    }
}