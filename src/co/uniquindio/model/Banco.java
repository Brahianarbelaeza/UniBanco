package co.uniquindio.model;

import java.util.ArrayList;
import java.util.Date;

public class Banco {

    private ArrayList<Cliente> listaClientes;
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Cuenta> listaCuentas;
    private ArrayList<Transaccion> listaTransacciones;

    public Banco() {
        this.listaClientes = new ArrayList<>();
        this.listaTransacciones = new ArrayList<>();
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
    public void depositar(String cedula, double monto){
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
    public void consultarSaldo(String cedula){

        Transaccion transaccion = new Transaccion(new Date(), (TipoTransaccion.CONSULTA_SALDO));
        transaccion.setEstado(Estado.EXITOSO);

    }

}