package jd.plano.teclas;

import java.awt.*;

public abstract class Tecla {
    //Variables de instancia
    protected Point posicion;
    private int nota;
    private boolean pulsada;
    private Color colorPulsada;
    private Graphics graphics;

    //Constructor
    Tecla(int n){
        this.posicion = null;
        this.colorPulsada = null;
        this.nota = n;
        this.pulsada = false;
        throw new UnsupportedOperationException("Falta la propiedad graphics de la clase ElementoVisual para que Alejandro la aplique");
    }

    //Métodos
    //getters
    public int getNumeroNota(){
        return this.nota;
    }
    //Abstractos
    protected abstract int[] getVerticesX();
    protected abstract int[] getVerticesY();
}
