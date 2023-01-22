package classes.banco;

import java.util.ArrayList;
import enums.Enums.MovimientosBanco;

public class CuentaCorriente {
    private String numero_cuenta;
    private double saldo;
    private ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();

    public String getNumeroCuenta() {
        return this.numero_cuenta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setMovimientos(Movimiento m) {
        this.movimientos.add(m);
    }

    public CuentaCorriente() {
        this(0);
    }

    public CuentaCorriente(double saldo) {
        String cuenta = "";
        for (int i = 0; i < 10; i++) {
            cuenta += (int) (Math.random() * 10);
        }
        this.numero_cuenta = cuenta;
        this.saldo = saldo;
    }

    public void ingreso(double cantidad) throws ApunteException {
        ingreso(cantidad, null);
    }

    public void ingreso(double cantidad, CuentaCorriente origen) throws ApunteException {
        if (cantidad <= 0)
            throw new ApunteException();
        else {
            Movimiento m;
            String info;
            this.saldo += cantidad;
            if (origen == null) {
                info = String.format("Ingreso de %.0f €  Saldo: %.2f €", cantidad, this.saldo);
                m = new Movimiento(MovimientosBanco.INGRESO, cantidad, info);
                movimientos.add(m);
            } else {
                info = String.format("Transf. recibida de %.0f € de la cuenta %s  Saldo: %.2f €",
                        cantidad, origen.getNumeroCuenta(), this.getSaldo());
                m = new Movimiento(MovimientosBanco.TRANSFERENCIA, cantidad, origen, this, info);
                this.setMovimientos(m);
            }
        }
    }

    public void cargo(double cantidad) throws ApunteException {
        cargo(cantidad, null);
    }

    public void cargo(double cantidad, CuentaCorriente destino) throws ApunteException {
        if (cantidad <= 0)
            throw new ApunteException();
        else {
            Movimiento m;
            String info;
            this.saldo -= cantidad;
            if (destino == null) {
                info = String.format("Cargo de %.0f €  Saldo: %.2f €", cantidad, this.saldo);
                m = new Movimiento(MovimientosBanco.CARGO, cantidad, info);
                movimientos.add(m);
            } else {
                info = String.format("Transf. emitida de %.0f € a la cuenta %s  Saldo: %.2f €",
                        cantidad, destino.getNumeroCuenta(), this.saldo);
                m = new Movimiento(MovimientosBanco.TRANSFERENCIA, cantidad, this, destino, info);
                movimientos.add(m);
            }
        }
    }

    public void transferencia(CuentaCorriente c, double cantidad) throws ApunteException {
        this.cargo(cantidad, c);
        c.ingreso(cantidad, this);
    }

    public void movimientos() {
        System.out.println("\nMovimientos de la cuenta " + this.numero_cuenta);
        System.out.println("----------------------------------");
        for (int i = 0; i < movimientos.size(); i++)
            System.out.println(movimientos.get(i).getInformacion());
    }

    @Override
    public String toString() {
        return String.format("Número de cta: %s Saldo: %.2f €", this.numero_cuenta, this.saldo);
    }
}
