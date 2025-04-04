package jd.plano.teclas;

public class TeclaFactory {
    //Constructor vácio según el patrón de diseño Factory Method o Virtual Constructor
    private TeclaFactory(){
    }

    //Método statico
    public static Tecla crearTecla(int nota){
        //Indica el tipo correcto de nota en función de una tabla adjunta en la documentación
        int restoNota = nota%12; //Resultado entre 0 y 11

        //Crea la tecla
        Tecla tecla = switch (restoNota){
            case 0, 5 -> new TeclaBlanca1(nota);
            case 2, 7, 9 -> new TeclaBlanca2(nota);
            case 4, 11 -> new TeclaBlanca3(nota);
            default -> new TeclaNegra(nota);
        };
        return tecla;
    }
}
