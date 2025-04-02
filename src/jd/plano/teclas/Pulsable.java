package jd.plano.teclas;

import java.awt.*;

public interface Pulsable implements ElementoVisual{
    //Abstract
    public abstract void pulsar();
    public abstract void soltar();
    public abstract boolean estaPulsado();
    public abstract void setColorPulsado(Color c);
    public abstract Color getColorPulsado();
    public abstract Color getColorNoPulsado();

    //Métodos default
    public default Color getColor(){
        Color color = null;
        if(this.estaPulsado()){
            color = this.getColorPulsado();
        }else{
            color = this.getColorNoPulsado();
        }
        return color;
    }
}
