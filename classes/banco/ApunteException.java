package classes.banco;

public class ApunteException extends Exception {
    public int code;
    public String msg;

    public ApunteException () {
        this.code = 100;
        this.msg = "No es posible realizra un apunte con un importe negativo o nulo";
    }

    @Override
    public String toString () {
        return "Message: " + this.msg + " Code: " + this.code;
    }
}
