package jd.plano.teclas;

public class TeclaBlanca2 extends TeclaBlanca {
    TeclaBlanca2(int n){
        super(n);
    }

    @Override
    public int[] getVerticesX() {
        int x = (int) posicion.getX();
        int B = TeclaBlanca.ANCHURA;
        int N = TeclaNegra.ANCHURA;
        return new int[]{x, x+N/2, x+B-N/2, x+B};
    }

    @Override
    public int[] getVerticesY() {
        int y = (int) posicion.getY();
        int B = TeclaBlanca.ANCHURA;
        int N = TeclaNegra.ANCHURA;
        return new int[]{y, y+TeclaNegra.ALTURA, y+TeclaBlanca.ALTURA};
    }
}