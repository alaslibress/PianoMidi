package jd.plano.programa;

import bpc.daw.consola.Consola;
import jd.plano.teclas.Piano;

import java.io.File;

public class Programa {
    public static void main(String[] args) {
        Consola c = new Consola();
        c.getCapaTexto().println("¿Cual es la ruta del archivo?");
        String ruta = c.getTeclado().leerCadenaCaracteres();
        File f = new File(ruta);
        if(!f.exists()){
            c.getCapaTexto().println("ERROR: El archivo no existe");
        }
        c.getCapaTexto().println("""
                ¿Donde desea reproducir el archivo?
                1. Piano Sencillo
                2. Multi Piano""");
        int opcion = c.getTeclado().leerNumeroEntero();
        switch (opcion) {
            case 1 -> {
                throw new UnsupportedOperationException("No Programado");
            }
            case 2 -> {
                throw new UnsupportedOperationException("No Programado");
            }
            default -> c.getCapaTexto().println("ERROR: Opción no válida");
        }
    }
}
