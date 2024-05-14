package corredores;

import sponsors.Patrocinable;

public class Corredor implements Patrocinable {

    private int distanciaMaxima;
    private int cantidadCarreras;
    private int puntaje;
    private boolean certificado;


    public boolean tieneCertificado() {
        return certificado;
    }

    /* Si distancia es mayor actualiza la distancia máxima corrida hasta el momento
     */
    public void actualizarDistancia(int distancia) {

        if (distancia > this.distanciaMaxima) {
            distanciaMaxima = distancia;
        }

    }

    public void incrementarContadorCarreras(){
        cantidadCarreras ++;
    }

    /**
     * Los corredores pueden ser patrocinados solamente
     * si tienen más de 3 carreras corridas.
     */
    @Override
    public boolean podesSerPatrocinado() {
        return cantidadCarreras > 3;
    }

    public int getPuntaje() {
        return puntaje;
    }

    /**
     * Recibir puntos y sumar al puntaje actual.
     */
    public void recibirPuntos(int puntos) {
        this.puntaje = this.puntaje + puntos;
    }
}
