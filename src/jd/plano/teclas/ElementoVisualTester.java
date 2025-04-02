package jd.plano.teclas;

import bpc.daw.consola.Consola;
import bpc.daw.consola.Consola.*;
import bpc.daw.consola.FondoColorSolido;

import java.awt.*;

public class ElementoVisualTester {
    // Variables de instancia
    private Graphics graphics;
    private ElementoVisual elementoVisual;

    // Constructor principal
    public ElementoVisualTester(Graphics g){
        this.graphics = g;
        this.elementoVisual = null;

    }

    //Constructor secundario
    public ElementoVisualTester (){
        Consola c = new Consola();
        FondoColorSolido colorFondo = new FondoColorSolido(Color.darkGray);
        c.getCapaFondo().setFondo(colorFondo);

        this.graphics = c.getCapaCanvas().getGraphics();
        this.elementoVisual = null;
    }

    //Metodos de la clase
    public void setElementoVisual(ElementoVisual e){
        this.elementoVisual = e;
    }
    public boolean hacerPrueba(){
        throw new UnsupportedOperationException("Metodo sin programar aun, Pablo H");
    }
}