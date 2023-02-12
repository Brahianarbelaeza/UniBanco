package co.uniquindio.model;

import java.util.Objects;

public class Cliente {

    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String email;


    public Cliente(String nombre, String apellido, String cedula, String direccion, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido) && Objects.equals(cedula, cliente.cedula) && Objects.equals(direccion, cliente.direccion) && Objects.equals(email, cliente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido, cedula, direccion, email);
    }

    public boolean compararCliente(Cliente cliente) {
        return equals(cliente);
    }
}
