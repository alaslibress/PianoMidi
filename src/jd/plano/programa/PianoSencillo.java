package jd.plano.programa;

import bpc.daw.consola.CapaCanvas;
import bpc.daw.consola.Consola;
import jd.plano.teclas.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PianoSencillo extends Piano {

    private Map<Integer, Tecla> teclas;

    public PianoSencillo(int teclaInicial, int teclaFinal) {
        super();
        this.teclas = new HashMap<>();
        for (int nota = teclaInicial; nota <= teclaFinal; nota++) {
            Tecla tecla = TeclaFactory.crearTecla(nota);
            this.teclas.put(nota, tecla);
        }
    }

    @Override
    public void setGraphics(Graphics g) {
        for (Tecla tecla : teclas.values()) {
            tecla.setGraphics(g);
        }
    }

    @Override
    public void dibujar() {
        for (Tecla tecla : teclas.values()) {
            tecla.dibujar();
        }
    }

    @Override
    public void setPosicion(int x, int y) {
        Consola consola = new Consola();
        CapaCanvas canvas = consola.getCapaCanvas();
        int x1 = x;
        int y1 = y;
        // Se obtiene la lista de notas en orden ascendente
        List<Integer> notas = new ArrayList<>(teclas.keySet());
        Collections.sort(notas);
        // Se recorre cada tecla y se le asignan las posiciones según su tipo (blanca o negra)
        for (Integer nota : notas) {
            Tecla tecla = teclas.get(nota);
            tecla.setGraphics(canvas.getGraphics());
            if (tecla instanceof TeclaBlanca) {
                tecla.setPosicion(x1, y1);
                x1 += tecla.getAnchura();
            } else {
                tecla.setPosicion(x1 - TeclaNegra.ANCHURA / 2, y1);
            }
        }
        dibujar();
    }

    @Override
    public Tecla getTecla(int canal, int nota) {
        return teclas.get(nota);
    }

    @Override
    public int getAnchura() {
        int anchura = 0;
        for (Tecla tecla : teclas.values()) {
            if (tecla instanceof TeclaBlanca) {
                anchura += tecla.getAnchura();
            }
        }
        return anchura;
    }

    @Override
    public int getAltura() {
        return TeclaBlanca.ALTURA;
    }
}