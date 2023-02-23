package co.uniquindio.controller;

import co.uniquindio.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ConsultaSaldoController extends Controller {

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtSaldo;
    void consultarSaldo(ActionEvent event) {
        String cedula = txtCedula.getText();
        try {
            Cliente clienteEncontrado= getListaCliente().stream().filter((x) -> cedula.equals(x.getCedula())).findFirst().get();
            txtSaldo.setText("El saldo actual es: " + clienteEncontrado.getCuenta().getSaldo());
            super.consultarSaldo(cedula);
        } catch (Exception e) {
            txtSaldo.setText("No se encontro el cliente");
        }

    }
}

