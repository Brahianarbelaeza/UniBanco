package co.uniquindio.model;

import java.util.ArrayList;

public class Banco {

    private ArrayList<Cliente> listaClientes;

    public Banco() {
        this.listaClientes = new ArrayList<>();
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public void actualizarCliente() {


    }

    public void crearCliente(Cliente cliente) {
        boolean flag = false;
        for (int i=0; i<listaClientes.size(); i++){
            if(cliente.compararCliente(listaClientes.get(i))){
                flag = true;
                break;
            }
        }

        if(!flag) {
            listaClientes.add(cliente);
            System.out.println("Se guardo el cliente");
        }else{
            System.out.println("Este cliente ya se guardo");
        }

    }
}
