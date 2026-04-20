import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class tddSampleTest {
    @Test
    void testAlCrearCuentaElSaldoEsCero(){
        Cuenta c = new Cuenta();
        assertEquals(0, c.getSaldo());
    }
    @Test
    void testAlIngresar100EnCuentaVaciaElSaldoEs100(){
        Cuenta c = new Cuenta();
        c.ingresar(100);
        assertEquals(100,c.getSaldo());
    }
    @Test
    void testAlIngresar3000EnCuentaVaciaElSaldoEs3000(){
        Cuenta c = new Cuenta();
        c.ingresar(3000);
        assertEquals(3000,c.getSaldo());
    }
    @Test
    void testAlIngresar100EnCuentaCon3000ElSaldoEs3100(){
        Cuenta c = new Cuenta();
        c.ingresar(100);
        c.ingresar(3000);
        assertEquals(3100,c.getSaldo());
    }
    @Test
    void testNoSePuedeIngresarCAntidadNegativa() {
        Cuenta c = new Cuenta();
        c.ingresar(-100);
        assertEquals(0,c.getSaldo());
    }
    @Test
    void IngresoCantidad2Decimales(){
        Cuenta c = new Cuenta();
        c.ingresar(100.45);
        assertEquals(100.45,c.getSaldo());
    }
    @Test
    void testIngresoMaximoEsDe6000(){
        Cuenta c = new Cuenta();
        c.ingresar(6000);
        assertEquals(6000,c.getSaldo());
    }
    @Test
    void testIngresoMasDe6000NoEsValido(){
        Cuenta c = new Cuenta();
        c.ingresar(6000.01);
        assertEquals(0,c.getSaldo());
    }

}