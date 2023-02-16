package co.uniquindio.model;

import java.util.Date;

public class Retiro extends Transaccion {
    private Double monto;
    public Retiro(  Date fecha, TipoTransaccion tipoTransaccion) {
        super(fecha, tipoTransaccion);
    }




}
