package jd.plano.teclas;

import java.awt.*;

public interface ElementoVisual extends Medible{

    public abstract void setPosicion(int x, int y);
    public abstract void setGraphics(Graphics g);
    public abstract void dibujar();
}