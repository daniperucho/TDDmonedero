public class Cuenta {
    private double saldo;

    public Cuenta(){
        saldo = 0.0f;
    }
    public double getSaldo() {
        return saldo;
    }
    public boolean esCantidadValida(double cantidad){
        if(cantidad <0 || cantidad >6000) {
            return false;
        }
        else {
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

}
