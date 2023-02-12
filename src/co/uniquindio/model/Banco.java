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

    public void actualizarCliente(Cliente clienteSelected, Cliente clienteNuevo) {

        clienteSelected.setNombre(clienteNuevo.getNombre());
        clienteSelected.setApellido(clienteNuevo.getApellido());
        clienteSelected.setCedula(clienteNuevo.getCedula());
        clienteSelected.setDireccion(clienteNuevo.getDireccion());
        clienteSelected.setEmail(clienteNuevo.getEmail());


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
        }else{
            System.out.println("Este cliente ya se guardo");
        }

    }

    public void eliminarCliente(Cliente clienteSelected) {
      listaClientes.remove(clienteSelected);

    }

    public void hacerRetiro(String cedula, double monto) {
        System.out.println("Retirando");
        for (int i=0; i<listaClientes.size(); i++){
            if(listaClientes.get(i).getCedula().equals(cedula)){
                System.out.println("Encontrado");
                if(listaClientes.get(i).getCuenta().getSaldo() >= monto) {
                    listaClientes.get(i).getCuenta().setSaldo(listaClientes.get(i).getCuenta().getSaldo() - monto);
                    System.out.println("Retiro exitoso");
                }else{
                    System.out.println("No tiene saldo suficiente");
                }
                break;
            }
        }
    }
}
