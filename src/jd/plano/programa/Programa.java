package jd.plano.programa;

import java.io.File;
import bpc.daw.consola.*;
import jd.plano.programa.MultiPiano;
import jd.plano.programa.PianoSencillo;
import jd.plano.programa.ReproductorMidi;
import jd.plano.teclas.Piano;

public class Programa {

    public static void main(String[] args) {
        Consola consola = new Consola();
        consola.getCapaFondo().setFondo(new FondoColorSolido(0, 0, 70));

        Teclado teclado = consola.getTeclado();
        CapaTexto capaTexto = consola.getCapaTexto();

        capaTexto.println("Introduce la ruta del archivo MIDI: ");
        String rutaArchivo = teclado.leerCadenaCaracteres();

        File archivo = new File(rutaArchivo);
        if (!archivo.exists() || !archivo.isFile()) {
            capaTexto.println("El archivo especificado no existe. El programa finalizará.");
        }

        capaTexto.println("¿Dónde deseas reproducir la canción?");
        capaTexto.println("1. Piano Sencillo");
        capaTexto.println("2. Multi Piano");

        int opcion = 0;
        try {
            opcion = teclado.leerNumeroEntero();
        } catch (Exception e) {
            capaTexto.println("Opción no válida. El programa finalizará.");
        }

        if (opcion != 1 && opcion != 2) {
            capaTexto.println("Opción no válida. El programa finalizará.");
        }

        CapaCanvas capaCanvas = consola.getCapaCanvas();

        Piano piano = null;
        if (opcion == 1) {
            piano = new PianoSencillo(24, 108);
        } else {
            piano = new MultiPiano(24, 108);
        }

        piano.setPosicion(50, 50);
        piano.setGraphics(capaCanvas.getGraphics());

        ReproductorMidi reproductor = new ReproductorMidi();
        reproductor.conectar(piano);

        reproductor.reproducir(rutaArchivo);
    }
}
