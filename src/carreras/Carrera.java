package carreras;

import corredores.Corredor;
import sponsors.Patrocinable;

import java.util.HashSet;
import java.util.Set;

public abstract class Carrera implements Patrocinable {

    protected int distancia;

    // Optamos por un hash porque no queremos que se pueda
    // repetir un corredor en una misma carrera
    protected Set<Corredor> corredores = new HashSet<>();

    public Carrera(int distancia) {
        this.distancia = distancia;
    }

    // Metodos abstractos para ser implementados según el requerimiento de cada
    // tipo de carrera.
    public abstract void inscribir(Corredor unCorredor);

    // Este método no lo pide explicito el enunciado pero nos permite facilitar
    // el proceso de inscripción, ya que todas las carreras necesitan una validacion
    public abstract boolean estaAutorizado(Corredor unCorredor);


    public int getDistancia() {
        return distancia;
    }

}
