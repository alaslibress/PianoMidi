package jd.plano.teclas;

import org.junit.Test;

import static org.junit.Assert.*;

public class TeclaBlanca2Test {
    @Test
    public void testTeclaBlanca2() {
        TeclaBlanca2 teclaBlanca2 = new TeclaBlanca2(60);
        ElementoVisualTester tester = new ElementoVisualTester();
        tester.setElementoVisual(teclaBlanca2);
        if (!tester.hacerPrueba()) {
            fail("La prueba visual de TeclaBlanca2 ha fallado");
        }
    }

}