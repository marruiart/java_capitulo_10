package classes.banco;

import enums.Enums.MovimientosBanco;

public class Movimiento {
    private MovimientosBanco tipo;
    private double cantidad;
    private CuentaCorriente ori, dest;
    private String informacion;

    public Movimiento(MovimientosBanco tipo, double cantidad, String informacion) {
        this(tipo, cantidad, null, null, informacion);
    }

    public Movimiento(MovimientosBanco tipo, double cantidad, CuentaCorriente ori, CuentaCorriente dest,
            String informacion) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.ori = ori;
        this.dest = dest;
        this.informacion = informacion;
    }

    public MovimientosBanco getTipo() {
        return tipo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public CuentaCorriente getOri() {
        return ori;
    }

    public CuentaCorriente getDest() {
        return dest;
    }

    public String getInformacion() {
        return informacion;
    }
}
