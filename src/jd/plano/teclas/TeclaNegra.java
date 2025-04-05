package jd.plano.teclas;

import java.awt.*;

public class TeclaNegra extends Tecla {
    public static final int ANCHURA = 15;
    public static final int ALTURA = 50;

    TeclaNegra(int n) {
        super(n);
    }

    @Override
    public int[] getVerticesX() {
        int x = (int) posicion.getX();
        return new int[]{x, x, x + TeclaNegra.ANCHURA, x + TeclaNegra.ANCHURA};
    }

    @Override
    public int[] getVerticesY() {
        int y = (int) posicion.getY();
        return new int[]{y, y + TeclaNegra.ALTURA, y + TeclaNegra.ALTURA, y};
    }


    @Override
    public Color getColorNoPulsado() {
        return Color.black;
    }

    @Override
    public int getAnchura() {
        return TeclaNegra.ANCHURA;
    }

    @Override
    public int getAltura() {
        return TeclaNegra.ALTURA;
    }
}