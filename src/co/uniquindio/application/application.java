package co.uniquindio.application;


import co.uniquindio.controller.Controller;
import co.uniquindio.model.Banco;
import co.uniquindio.model.Cliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class application extends Application {


    private Banco banco;

    public static void main(String[] args) {

        launch();


    }

    public Banco getBanco() {
        return banco;
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

    public void actualizarCliente(Cliente clienteSelected, Cliente clienteNuevo) {

        banco.actualizarCliente(clienteSelected, clienteNuevo);
    }

    public void crearCliente(Cliente cliente) {
      if   (!getListaClientes().contains(cliente))
          banco.crearCliente(cliente);

        else {

            System.out.println("Cliente ya existe");
        }

    }

    public ArrayList<Cliente> getListaClientes() {
        return banco.getListaClientes();
    }

    public void eliminarCliente(Cliente clienteSelected) {
        banco.eliminarCliente(clienteSelected);
    }

    public void retirar() {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/retirarView.fxml"));
        AnchorPane pane = null;
        try {
            pane = loader.load();
            Controller controller = loader.getController();
            controller.setMain(this);
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }

    public void hacerRetiro(String cedula, double monto) {
        banco.hacerRetiro(cedula, monto);
    }

    public void anadirTransacciiones (){
        banco.anadirTransacciones();
    }

    public void depositar() {
        Stage stage1 = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/DepositarSaldo.fxml"));
        AnchorPane pane = null;
        try {
            pane = loader.load();
            Controller controller = loader.getController();
            controller.setMain(this);
            Scene scene1 = new Scene(pane);
            stage1.setScene(scene1);
            stage1.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void hacerDeposito(String cedula, double monto) {
        banco.hacerDeposito(cedula, monto);
    }
}