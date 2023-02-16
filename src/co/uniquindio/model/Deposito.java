package co.uniquindio.model;

import java.util.Date;

public class Deposito extends Transaccion {

    public Deposito( Date fecha, TipoTransaccion tipoTransaccion) {
        super(fecha, tipoTransaccion);
    }
}
