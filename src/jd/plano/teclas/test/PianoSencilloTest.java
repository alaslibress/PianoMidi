package jd.plano.teclas.test;

import jd.plano.programa.PianoSencillo;
import jd.plano.teclas.ElementoVisualTester;
import org.junit.Test;

import static org.junit.Assert.*;

public class PianoSencilloTest {

    @Test
    public void test1() {
        PianoSencillo piano = new PianoSencillo(36, 72);
        ElementoVisualTester tester = new ElementoVisualTester();
        tester.setElementoVisual(piano);
        boolean resultado = tester.hacerPrueba();
        if (!resultado) {
            fail("La prueba visual del piano no salió correctamente");
        }
    }

    @Test
    public void test2() {
        PianoSencillo piano = new PianoSencillo(36, 48);
        assertEquals(325, piano.getAnchura());
        assertEquals(100, piano.getAltura());
    }
}