import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class tddSampleTest {
    @Test
    void testAlCrearCuentaElSaldoEsCero(){
        Cuenta c = new Cuenta();
        assertEquals(0, c.getSaldo());
    }

}