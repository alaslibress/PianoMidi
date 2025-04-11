package jd.plano.teclas;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TeclaBlanca3Test {
    @Test
    public void testTeclaBlanca3() {
        TeclaBlanca3 teclaBlanca3 = new TeclaBlanca3(64);
        teclaBlanca3.setColorPulsado(Color.BLUE);
        ElementoVisualTester tester = new ElementoVisualTester();
        tester.setElementoVisual(teclaBlanca3);
        if (!tester.hacerPrueba()) {
            fail("La prueba visual de TeclaBlanca3 ha fallado");
        }
    }
}