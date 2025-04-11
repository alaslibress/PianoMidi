package jd.plano.teclas;

public class TeclaBlanca3 extends TeclaBlanca{
    TeclaBlanca3(int n){
        super(n);
    }
    @Override
    public int[] getVerticesX() {
        int x = (int) posicion.getX();
        final int B = TeclaBlanca.ANCHURA;
        final int N = TeclaNegra.ANCHURA;
        return new int[]{x, x, x+B, x+B, x+(N/2), x+(N/2)};
    }

    @Override
    public int[] getVerticesY() {
        int y = (int) posicion.getY();
        int B = TeclaBlanca.ANCHURA;
        int N = TeclaNegra.ANCHURA;
        return new int[]{y, y+TeclaNegra.ALTURA, y+TeclaBlanca.ALTURA};
    }
}