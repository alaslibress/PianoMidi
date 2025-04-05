package jd.plano.teclas;

import java.awt.*;

public abstract class TeclaBlanca extends Tecla{
    public static final int ALTURA=100;
    public static final int ANCHURA=25;

    TeclaBlanca(int n){
        super(n);
    }

    @Override
    public Color getColorNoPulsado() {
        return Color.white;
    }

    @Override
    public int getAnchura() {
        return TeclaBlanca.ANCHURA;
    }

    @Override
    public int getAltura() {
        return TeclaBlanca.ALTURA;
    }

    @Override
    protected int[] getVerticesY() {
        return new int[0];
    }

    @Override
    protected int[] getVerticesX() {
        return new int[0];
    }
}
