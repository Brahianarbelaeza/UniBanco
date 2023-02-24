package co.uniquindio.controller;

import co.uniquindio.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RetirarController extends Controller{

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtMonto;
    @FXML
    private TextField txtMostrarsaldo;

    @FXML void retirar(ActionEvent event) {

        String cedula = txtCedula.getText();
        try {

            double monto = Double.parseDouble(txtMonto.getText());
            super.hacerRetiro(cedula, monto);
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir el monto, ingrese numeros validos");
        }

        Cliente clienteEncontrado= getListaCliente().stream().filter((x) -> cedula.equals(x.getCedula())).findFirst().get();
        txtMostrarsaldo.setText("El saldo actual es: " + clienteEncontrado.getCuenta().getSaldo());
    }

}
