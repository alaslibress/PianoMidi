package jd.plano.teclas;

import bpc.daw.consola.CapaCanvas;
import bpc.daw.consola.Consola;

import java.awt.*;

public abstract class Tecla implements Pulsable{
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
        this.graphics = new Consola().getCapaCanvas().getGraphics();
    }

    //Métodos
    //getters
    public int getNumeroNota(){
        return this.nota;
    }
    //Abstractos
    protected abstract int[] getVerticesX();
    protected abstract int[] getVerticesY();

    //Herencia
    @Override
    public void setPosicion(int x, int y) {
        this.posicion.setLocation(new Point(x, y));
    }
    @Override
    public void pulsar() {
        this.pulsada = true;
    }
    @Override
    public void soltar() {
        this.pulsada = false;
    }
    @Override
    public void dibujar() {
        //En caso de no haber alterado los valores por defecto:
        if(this.posicion == null || this.graphics == null){
            throw new IllegalStateException("Hay que llamar a setPosición y setGraphics antes de llamar al método dibujar");
        }

        //Asignamos a graphics un color del método getColor
        this.graphics.setColor(this.getColor());

        //Dibujamos un polígono con las coordenadas de getVertices (Son abstractos y se programan en clases hijas)
        this.graphics.fillPolygon(this.getVerticesX(), this.getVerticesY(), 4); //4 nPoints al ser una tecla cuadrada

        //Cambiamos color de graphics a negro
        this.graphics.setColor(Color.BLACK);

        //Pintamos el borde de color negro de la tecla
        this.graphics.drawPolygon(this.getVerticesX(), this.getVerticesY(), 4);
    }
    @Override
    public void setColorPulsado(Color c) {
        this.colorPulsada = c;
    }
    //Getters heredados
    @Override
    public boolean estaPulsado() {
        return this.pulsada;
    }
    @Override
    public Color getColorPulsado() {
        return this.colorPulsada;
    }
}
