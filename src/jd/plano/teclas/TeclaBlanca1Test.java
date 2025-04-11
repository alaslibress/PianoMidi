package jd.plano.teclas;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TeclaBlanca1Test {
    @Test
    public void testTeclaBlanca1() {
        TeclaBlanca1 teclaBlanca1 = new TeclaBlanca1(60);
        teclaBlanca1.setColorPulsado(Color.BLUE);
        ElementoVisualTester tester = new ElementoVisualTester();
        tester.setElementoVisual(teclaBlanca1);
        if (!tester.hacerPrueba()) {
            fail("La prueba visual de TeclaBlanca1 ha fallado");
        }
    }
}