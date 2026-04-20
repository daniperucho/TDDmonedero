public class Cuenta {
    private double saldo;

    public Cuenta(){
        saldo = 0.0f;
    }
    public double getSaldo() {
        return saldo;
    }
    public boolean esCantidadValida(double cantidad){
        if (cantidad < 0 || cantidad > 6000){
            return false;
        } else {
            return true;
        }
    }
    public void ingresar(double cantidad){
        if(!esCantidadValida(cantidad)) {
            saldo = 0.0f;
        }
        else {
            saldo += cantidad;
        }
    }

    private boolean esRetiradaValida(double cantidad){
        if (cantidad <= 0){
            return false;
        } else if (cantidad >= saldo) {
            return false;
        } else if (cantidad > 6000){
            return false;
        } else {
            return true;
        }
    }

    public void retirar(double cantidad) {
        if (!esRetiradaValida(cantidad)) return;
        saldo -= cantidad;
    }

    private boolean esTransferenciaValida(double cantidad){
        if (cantidad < 0){
            return false;
        } else if (cantidad > 3000){
            return false;
        } else{
            return true;
        }
    }

    public void transferir(Cuenta destino, double cantidad) {
        if (!esTransferenciaValida(cantidad)) return;
        this.saldo -=cantidad;
        destino.saldo += cantidad;
    }
}
