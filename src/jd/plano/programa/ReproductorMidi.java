package jd.plano.programa;

import jd.plano.teclas.Piano;
import jd.plano.teclas.Tecla;

import javax.sound.midi.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ReproductorMidi implements Receiver {
    //Variables de instnacia
    private static final Color[] COLORES = {Color.CYAN, Color.BLUE, Color.GREEN, Color.MAGENTA,
    Color.ORANGE, Color.PINK, Color.YELLOW, Color.RED, Color.DARK_GRAY, Color.LIGHT_GRAY,
    new Color(64, 236, 127), new Color(227, 162, 84), new Color(174, 246, 12),
    new Color(113, 172, 209), new Color(202, 184, 155), new Color(50, 142, 72)};
    private Piano piano;

    //Constructor
    public ReproductorMidi(){
        this.piano = null;
    }

    //Métodos
    public void conectar(Piano p){
        this.piano = p;
    }
    public void reproducir(String ruta){
        //Cargamos la canción en un sequencer para obtener un sequence
        try {
            Sequence sequence = MidiSystem.getSequence(new File(ruta));

            //Creamos un dispositivo sequencer
            Sequencer sequencerDispositivo = MidiSystem.getSequencer();
            sequencerDispositivo.open(); //abrir secuenciador

            //Creamos un transmiter mediante el sequencer
            Transmitter transmitter = sequencerDispositivo.getTransmitter();

            transmitter.setReceiver(this); //Conectamos con este reproductor usando this
            sequencerDispositivo.setSequence(sequence); //Introducimos en el sequencer el sequence

            sequencerDispositivo.start(); //Comienza la reproducción

            //Realizamos una pausa con la duración de la canción.
            Thread.sleep(sequencerDispositivo.getSequence().getMicrosecondLength());

            //Liberamos los recursos del sistema
            transmitter.close();
            sequencerDispositivo.close();

            //Trataremos todas las runtime exception de forma individual para saber con precisión los posibles fallos
        } catch (InvalidMidiDataException e) {
            System.out.println("El archivo proporcionado no es un midi: "+e);
        } catch (IOException e) {
            System.out.println("Problemas con el get Sequence: "+e);
        } catch (MidiUnavailableException e) {
            System.out.println("Problema a la hora de llamar al sequencer dispositivo: "+e);
        } catch (InterruptedException e) {
            System.out.println("Problemas con el thread sleep a la hora de pausar el tiempo para la canción: "+e);
        }

    }

    //Métodos heredados
    @Override
    public void send(MidiMessage message, long timeStamp) {
        if(message instanceof ShortMessage){ //En caso afirmativo
            ShortMessage shortMessage = (ShortMessage) message; //Casting

            //Obtenemos el número del canal del mensaje
            int canalMensaje = shortMessage.getChannel();
            if(canalMensaje != 9){ //Mientras sea distinto a 9 seguimos
                //Al ser tipo 9 el instrumento es de percusión por lo que no lo mostramos, el resto sí
                int nota = shortMessage.getData1(); //Sacamos la nota musical

                //Obtenemos la tecla
                Tecla tecla = this.piano.getTecla(canalMensaje, nota);

                if(tecla!=null){ //Si la tecla existe
                    int numeroComando = shortMessage.getCommand(); //Comando que nos permite saber si una tecla es o no pulsada
                    if(numeroComando==ShortMessage.NOTE_ON){ //Caso tecla pulsada
                        int volumen = shortMessage.getData2(); //Volumen de la nota
                        if(volumen>0){ //Volumen positivo
                            //Asignamos un color mediante el canal del mensaje y llamamos a pulsar tecla
                            tecla.setColorPulsado(COLORES[canalMensaje]);
                            tecla.pulsar();
                        }else if(volumen==0){
                            tecla.soltar();
                        }
                        tecla.dibujar(); //Dibujamos la tecla pulsada independientemente del color y volumen
                    }else if(numeroComando==ShortMessage.NOTE_OFF){
                        tecla.soltar();
                        tecla.dibujar(); //Dibujamos la tecla aunque no esté pulsada
                    }
                }
            }
        }
        //Si no cumple el condicional el método termina
    }

    @Override
    public void close() { //Dejamos el método vacío.
    }
}
