package jd.plano.teclas;

import javax.swing.text.Position;
import java.awt.*;

public abstract class Piano implements ElementoVisual{
    //Variables de instancia
    private int teclaInicial;
    private int teclaFinal;
    private Position posicion;
    private Graphics graphics;

    //Constructor
    public Piano(){
        throw new UnsupportedOperationException("Clase no programada por Alejandro");
    }

    //Métodos
    public abstract Tecla getTecla(int canal, int nota);

    public int getTeclaInicial(){
        throw new UnsupportedOperationException("Clase no programada por Alejandro");
    }
    public int getTeclaFinal(){
        throw new UnsupportedOperationException("Clase no programada por Alejandro");
    }
}
