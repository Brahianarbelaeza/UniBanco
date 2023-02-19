package co.uniquindio.model;

import java.util.ArrayList;
import java.util.Date;

public class Transaccion {
    private Double valor;
    private Date fecha;
    private TipoTransaccion tipoTransaccion;
    private Cuenta tipoCuenta;
    private Estado estado;

    public Transaccion( Date fecha, TipoTransaccion tipoTransaccion) {

        this.fecha = fecha;
        this.tipoTransaccion = tipoTransaccion;
    }





    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
