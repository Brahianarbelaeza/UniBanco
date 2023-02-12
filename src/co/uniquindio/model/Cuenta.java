package co.uniquindio.model;

public abstract class Cuenta {

    private String numeroCuenta;
    private Double saldo;


    public Cuenta(String numeroCuenta, Double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
}
