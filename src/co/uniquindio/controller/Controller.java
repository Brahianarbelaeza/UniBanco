package co.uniquindio.controller;

import co.uniquindio.application.application;
import co.uniquindio.model.Cliente;

import java.util.ArrayList;

public abstract class Controller {

    private application main;

    public application getMain() {
        return main;
    }

    public void setMain(application main) {
        this.main = main;
    }

    public void actualizarCliente(Cliente clienteSelected, Cliente clienteNuevo){
        main.actualizarCliente(clienteSelected, clienteNuevo);
    }

    protected void crearCliente(Cliente cliente) {
        main.crearCliente(cliente);

    }

    protected ArrayList<Cliente> getListaCliente() {
        return main.getListaClientes();
    }

    protected void eliminarCliente(Cliente clienteSelected) {
        main.eliminarCliente(clienteSelected);
    }

    protected void retirar() {
        main.retirar();
    }
    protected void depositar()  {
        main.depositar();

    }
    protected void hacerRetiro(String cedula, double monto) {
        main.hacerRetiro(cedula, monto);
    }
    protected void hacerDeposito(String cedula, double monto) {
        main.hacerDeposito(cedula, monto);
    }

    protected  void solicitarSaldo() {
        main.solicitarSaldo();
    }
    protected void consultarSaldo(String cedula) {
        main.consultarSaldo(cedula);
    }
}
