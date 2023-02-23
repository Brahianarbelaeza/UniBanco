package co.uniquindio.model;

import java.util.ArrayList;
import java.util.Date;

public class Transaccion {
    private Double valor;
    private Date fecha;
    private TipoTransaccion tipoTransaccion;

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    private Cuenta tipoCuenta;
    private Estado estado;

    public Transaccion( Date fecha, TipoTransaccion tipoTransaccion) {

        this.fecha = fecha;
        this.tipoTransaccion = tipoTransaccion;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "valor=" + valor +
                ", fecha=" + fecha +
                ", tipoTransaccion=" + tipoTransaccion +
                ", tipoCuenta=" + tipoCuenta +
                ", estado=" + estado +
                '}';
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
