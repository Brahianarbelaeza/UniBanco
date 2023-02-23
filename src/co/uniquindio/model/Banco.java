package co.uniquindio.model;

import com.sun.javafx.UnmodifiableArrayList;

import java.util.ArrayList;
import java.util.Date;

public class Banco {

    private ArrayList<Cliente> listaClientes;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Cuenta> listaCuentas;
    private ArrayList<Transaccion> listaTransacciones;


    public Banco() {this.listaClientes = new ArrayList<>();
/*
        Cliente cliente = new Cliente("Ale","Guzmán","123","Calle 10","aleja@gmail.com","Ahorros");
        Cliente cliente1 = new Cliente("Maria A","Ríos","234","Via M","mariale@gmail.com","Corriente");
        Cliente cliente2 = new Cliente("Juanse","Vega","696","Av centenarii","juanse@gmail.com","Ahorros");
        Cliente cliente3 = new Cliente("Daniel","Jimenez","880","Diagonal 64","dani@gmail.com","Corriente");

        listaClientes.add(cliente);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);
*/
    }

    public void anadirTransacciones(){

        this.listaTransacciones = new ArrayList<>();

        Transaccion transaccion = new Transaccion(new Date(12-03-2022), TipoTransaccion.DEPOSITO);
        Transaccion transaccion1 = new Transaccion(new Date(13-04-2022), TipoTransaccion.DEPOSITO);
        Transaccion transaccion2 = new Transaccion(new Date(16-06-2022), TipoTransaccion.DEPOSITO);
        Transaccion transaccion3 = new Transaccion(new Date(18-07-2022), TipoTransaccion.DEPOSITO);
        listaTransacciones.add(transaccion);
        listaTransacciones.add(transaccion1);
        listaTransacciones.add(transaccion2);
        listaTransacciones.add(transaccion3);

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
        for (int i = 0; i < listaClientes.size(); i++) {
            if (cliente.compararCliente(listaClientes.get(i))) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            listaClientes.add(cliente);
        } else {
            System.out.println("Este cliente ya se guardo");
        }

    }

    public void eliminarCliente(Cliente clienteSelected) {
        listaClientes.remove(clienteSelected);

    }

    public ArrayList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(ArrayList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }


    public void hacerRetiro(String cedula, double monto) {

        Cliente clienteEncontrado;
        clienteEncontrado = listaClientes.stream().filter((x) -> cedula.equals(x.getCedula())).findFirst().get();
        clienteEncontrado.getCuenta().getSaldo();
        if (clienteEncontrado.getCuenta().getSaldo() >= monto) {
            clienteEncontrado.getCuenta().setSaldo(clienteEncontrado.getCuenta().getSaldo() - monto);
            Transaccion transaccion = new Transaccion(new Date(), (TipoTransaccion.RETIRO));
            transaccion.setEstado(Estado.EXITOSO);
            listaTransacciones.add(transaccion);
        } else {
            Transaccion transaccion = new Transaccion(new Date(), (TipoTransaccion.RETIRO));
            transaccion.setEstado(Estado.FALLIDO);
            listaTransacciones.add(transaccion);
        }

    }
    public void hacerDeposito(String cedula, double monto){
        Cliente clienteEncontrado;
        clienteEncontrado = listaClientes.stream().filter((x) -> cedula.equals(x.getCedula())).findFirst().get();
        clienteEncontrado.getCuenta().getSaldo();
        clienteEncontrado.getCuenta().setSaldo(clienteEncontrado.getCuenta().getSaldo() + monto);
        Transaccion transaccion = new Transaccion(new Date(), (TipoTransaccion.DEPOSITO));
        transaccion.setEstado(Estado.EXITOSO);
        if (clienteEncontrado == null) {
            transaccion.setEstado(Estado.FALLIDO);
        }
        listaTransacciones.add(transaccion);
        System.out.println(transaccion.getEstado());

    }

}