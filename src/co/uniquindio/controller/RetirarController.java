package co.uniquindio.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RetirarController extends Controller{

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtMonto;

    @FXML
    void retirar(ActionEvent event) {

        String cedula = txtCedula.getText();
        try {

            double monto = Double.parseDouble(txtMonto.getText());
            super.hacerRetiro(cedula, monto);
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir el monto, ingrese numeros validos");
        }


    }

}
