package jd.plano.teclas.test;

import bpc.daw.consola.CapaCanvas;
import bpc.daw.consola.Consola;
import jd.plano.teclas.ElementoVisualTester;
import jd.plano.teclas.TeclaFactory;
import org.junit.Test;

import java.awt.*;

public class TeclaFactoryTest {
    @Test
    public void TestFactory(){
        //Buscamos con el test el visualizar la creación de teclas y su efecto visual a la hora de ser pulsadas.
        Consola consola = new Consola();
        CapaCanvas canvas = consola.getCapaCanvas();
        Graphics graphics = canvas.getGraphics();

        graphics.setColor(Color.GRAY);

        ElementoVisualTester elemento = new ElementoVisualTester(graphics);

        for(int i =60;i<=64;i++){
            elemento.setElementoVisual(
                    TeclaFactory.crearTecla(i)
            );
            if(elemento.hacerPrueba()){
                canvas.cls();
            }
        }
    }

}