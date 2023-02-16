package co.uniquindio.model;

public class Empleado {
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private String email;

    public Empleado(String nombre, String apellido, String cedula, String direccion, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.email = email;
    }

}
