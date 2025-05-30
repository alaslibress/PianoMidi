package jd.plano.teclas;

import java.awt.*;

public class TeclaBlanca1 extends TeclaBlanca{
    TeclaBlanca1(int n){
        super(n);
    }

    @Override
    protected int[] getVerticesX() {
        int x = (int)posicion.getX();
        int B = TeclaBlanca.ANCHURA;
        int N = TeclaNegra.ANCHURA;
        return new int[]{x, x+B-(N/2), x+B};
        }


    @Override
    protected int[] getVerticesY() {
        int y = (int) posicion.getY();
        int B = TeclaBlanca.ANCHURA;
        int N = TeclaNegra.ANCHURA;
        return new int[]{y, y+TeclaNegra.ALTURA, y+TeclaBlanca.ALTURA};
    }
}
