package jd.plano.teclas;
import org.junit.Test;

import java.awt.*;
import static org.junit.Assert.fail;

public class TeclaNegraTest {
    @Test
    public void TeclaNegraTest(){
        TeclaNegra teclaNegra = new TeclaNegra(61);
        teclaNegra.setColorPulsado(Color.blue);
        ElementoVisualTester tester = new ElementoVisualTester();
        tester.setElementoVisual(teclaNegra);
        if(!tester.hacerPrueba()) {
            fail("La prueba visual de TeclaNegra ha fallado");
        }
    }
}