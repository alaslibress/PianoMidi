// file: src/jd/plano/programa/MultiPiano.java
package jd.plano.programa;

import jd.plano.teclas.Piano;
import jd.plano.teclas.Tecla;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class MultiPiano extends Piano {

    private List<PianoSencillo> pianos;

    public MultiPiano(int teclaInicial, int teclaFinal) {
        super();
        pianos = new ArrayList<>();
        // Se crean 16 PianoSencillo, uno para cada canal
        for (int i = 0; i < 16; i++) {
            pianos.add(new PianoSencillo(teclaInicial, teclaFinal));
        }
    }

    @Override
    public Tecla getTecla(int canal, int nota) {
        if (canal < 0 || canal >= pianos.size()) {
            throw new IllegalArgumentException("Canal inválido");
        }
        return pianos.get(canal).getTecla(canal, nota);
    }

    @Override
    public void setGraphics(Graphics g) {
        // Propaga el Graphics a cada PianoSencillo sin almacenarlo en la clase
        for (PianoSencillo piano : pianos) {
            piano.setGraphics(g);
        }
    }

    @Override
    public void setPosicion(int x, int y) {
        // Calcula las dimensiones de un piano (suponiendo que todos son iguales)
        int anchuraPiano = pianos.get(0).getAnchura();
        int alturaPiano = pianos.get(0).getAltura();

        // Distribuir en una tabla de 8 filas y 2 columnas
        int columnas = 2;
        int filas = 8;
        int index = 0;
        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                if (index < pianos.size()) {
                    int posX = x + col * anchuraPiano;
                    int posY = y + fila * alturaPiano;
                    pianos.get(index).setPosicion(posX, posY);
                    index++;
                }
            }
        }
    }

    @Override
    public void dibujar() {
        // Simplemente dibuja cada PianoSencillo
        for (PianoSencillo piano : pianos) {
            piano.dibujar();
        }
    }

    @Override
    public int getAnchura() {
        return pianos.get(0).getAnchura();
    }

    @Override
    public int getAltura() {
        return pianos.get(0).getAltura();
    }
}