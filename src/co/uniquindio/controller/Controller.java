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

    public void actualizarCliente(){
        main.actualizarCliente();
    }

    protected void crearCliente(Cliente cliente) {
        main.crearCliente(cliente);

    }

    protected ArrayList<Cliente> getListaCliente() {
        return main.getListaClientes();
    }
}
