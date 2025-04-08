package jd.plano.teclas;

import bpc.daw.consola.Consola;
import bpc.daw.consola.Consola.*;
import bpc.daw.consola.FondoColorSolido;

import java.awt.*;

public class ElementoVisualTester {
    // Variables de instancia
    private Graphics graphics;
    private ElementoVisual elementoVisual;

    // Constructor principal
    public ElementoVisualTester(Graphics g){
        this.graphics = g;
        this.elementoVisual = null;

    }

    //Constructor secundario
    public ElementoVisualTester (){
        Consola c = new Consola();
        FondoColorSolido colorFondo = new FondoColorSolido(Color.darkGray);
        c.getCapaFondo().setFondo(colorFondo);

        this.graphics = c.getCapaCanvas().getGraphics();
        this.elementoVisual = null;
    }

    //Metodos de la clase
    public void setElementoVisual(ElementoVisual e){
        this.elementoVisual = e;
    }

    public boolean hacerPrueba() {
        boolean configurado = true;
        // Comprobacion por si no hay ningun elemento visual seleccionado
        if (elementoVisual == null) {
            throw new IllegalArgumentException("No se ha configurado ningún elemento visual");
        }
        // 1-CONFIGURAR EL ELEMENTO VISUAL
        elementoVisual.setPosicion(120, 90);
        elementoVisual.setGraphics(this.graphics);


        // 2-MOSTRAR EN PANTALLA EL ELEMENTO VISUAL
        elementoVisual.dibujar();

        // 3-COMPROBAR SI ES PULSABLE
        if (elementoVisual instanceof Pulsable) {
            Pulsable pulsable = (Pulsable) elementoVisual;
            // 3.1-ESTABLECER COLOR PULSADO AZUL
            pulsable.setColorPulsado(Color.BLUE);

            // 3.2-PAUSA DE 2 SEGUNDOS
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // 3.3-PULSAR PARA COMPROBAR QUE SE CAMBIA A AZUL
            pulsable.pulsar();

            // 3.4-PAUSA DE 2 SEGUNDOS
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // 3.5-SE LLAMA AL METODO SOLTAR Y VOLVERA A SU ESTADO ORIGINAL
            pulsable.soltar();
        }

        // 4-PREGUNTA AL USUARIO POR CONSOLADAW SI HA SALIDO BIEN EL TEST
        Consola c = new Consola();
        c.getCapaTexto().println("¿Ha salido el test bien? (s/n)");
        String respuesta = c.getTeclado().leerCadenaCaracteres();

        // 5-DEVUELVE TRUE O FALSE SEGUN LA RESPUESTA
        configurado = respuesta.trim().equalsIgnoreCase("s");
        return configurado;
    }
}