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
    @Test
    void testAlRetirar100EnCuentaCon500ElSaldoEs400() {
        Cuenta c = new Cuenta();
        c.ingresar(500);   // Arrange
        c.retirar(100);    // Act
        assertEquals(400, c.getSaldo());  // Assert
    }
    @Test
    void testNoSePuedeRetirarMasQueElSaldo() {
        Cuenta c = new Cuenta();
        c.ingresar(200);
        c.retirar(500);
        assertEquals(200, c.getSaldo());
    }
    @Test
    void testNoSePuedeRetirarCantidadNegativa() {
        Cuenta c = new Cuenta();
        c.ingresar(500);
        c.retirar(-100);
        assertEquals(500, c.getSaldo());
    }
    @Test
    void testRetiradaConDecimales() {
        Cuenta c = new Cuenta();
        c.ingresar(500);
        c.retirar(100.45);
        assertEquals(399.55, c.getSaldo());
    }
    @Test
    void testRetiradaMaxima6000() {
        Cuenta c = new Cuenta();
        c.ingresar(4000);
        c.ingresar(3000);
        c.retirar(6000);
        assertEquals(1000, c.getSaldo());
    }
    @Test
    void testRetiradaSuperiorA6000NoEsValida() {
        Cuenta c = new Cuenta();
        c.ingresar(4000);
        c.ingresar(3000);
        c.retirar(6000.01);
        assertEquals(7000, c.getSaldo());
    }
    @Test
    void testTransferenciaCorrecta() {
        Cuenta origen = new Cuenta();
        Cuenta destino = new Cuenta();

        origen.ingresar(500);
        destino.ingresar(50);

        origen.transferir(destino, 100);

        assertEquals(400, origen.getSaldo());
        assertEquals(150, destino.getSaldo());
    }
    @Test
    void testNoSePuedeTransferirCantidadNegativa() {
        Cuenta origen = new Cuenta();
        Cuenta destino = new Cuenta();

        origen.ingresar(500);
        destino.ingresar(50);

        origen.transferir(destino, -100);

        assertEquals(500, origen.getSaldo());
        assertEquals(50, destino.getSaldo());
    }
    @Test
    void testTransferenciaMaxima3000(){
        Cuenta origen = new Cuenta();
        Cuenta destino = new Cuenta();

        origen.ingresar(3500);
        destino.ingresar(50);

        origen.transferir(destino, 3000);

        assertEquals(500, origen.getSaldo());
        assertEquals(3050, destino.getSaldo());
    }
    @Test
    void testTransferenciaSuperiorA3000NoEsValida(){
        Cuenta origen = new Cuenta();
        Cuenta destino = new Cuenta();

        origen.ingresar(3500);
        destino.ingresar(50);

        origen.transferir(destino, 3000.01);

        assertEquals(3500, origen.getSaldo());
        assertEquals(50, destino.getSaldo());
    }
}