package co.uniquindio.controller;

import co.uniquindio.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DepositarController extends Controller{

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtMonto;

    @FXML  TextField mostrarMonto;
    private

    @FXML
    void depositar(ActionEvent event) {

        String cedula = txtCedula.getText();
        anadirTransacciones();
        try {

            double monto = Double.parseDouble(txtMonto.getText());
            super.hacerDeposito(cedula, monto);
            super.getMain().getBanco().getListaClientes().get(0).getCuenta().getSaldo();
            Cliente clienteEncontrado = getListaCliente().stream().filter((x) -> cedula.equals(x.getCedula())).findFirst().get();
            clienteEncontrado.getCuenta().setSaldo(monto);
            mostrarMonto.setText("Su nuevo saldo es de:" +clienteEncontrado.getCuenta().getSaldo());

        } catch (NumberFormatException e) {

            System.out.println("Error al depositar, ingrese un monto que sea valido");
        }






    }


}
