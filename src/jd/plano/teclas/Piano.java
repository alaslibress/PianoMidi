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
        //Todas las variables de instancia númericas toman valor por defecto 0 y a null los objetos
        this.teclaInicial = 0;
        this.teclaFinal = 0;
        this.posicion = null;
        this.graphics = null;
    }

    //Métodos
    //Abstractos
    public abstract Tecla getTecla(int canal, int nota);

    //Getters
    public int getTeclaInicial(){
        return this.teclaInicial;
    }
    public int getTeclaFinal(){
        return this.teclaFinal;
    }
}
