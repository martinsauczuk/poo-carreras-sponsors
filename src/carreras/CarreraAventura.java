package carreras;

import corredores.Corredor;


public class CarreraAventura extends Carrera {

    private int desnivel;
    private int cantMax;

    public CarreraAventura(int distancia, int desnivel, int cantMax) {
        super(distancia);
        this.desnivel = desnivel;
        this.cantMax = cantMax;
    }

    public void setCantMax(int cantMax) {
        this.cantMax = cantMax;
    }

    /**
     * Para hacer la cuenta de los puntos en un solo
     * lugar utilizamos un método.
     */
    private int calcularPuntos() {
        return this.puntosPorDesnivel() + this.puntosPorKm();
    }

    /**
     *  1 punto cada 1000m de desnive
     */
    private int puntosPorKm() {
        return this.desnivel / 1000;
    }

    /**
     * 1 punto cada 20km de distancia
     */
    private int puntosPorDesnivel() {
        return this.distancia / 20;
    }

    @Override
    public void inscribir(Corredor unCorredor) {
        if(estaAutorizado(unCorredor)) {
            corredores.add(unCorredor);
            unCorredor.actualizarDistancia(this.distancia);
            unCorredor.recibirPuntos( this.calcularPuntos() );
        }
    }

    @Override
    public boolean estaAutorizado(Corredor unCorredor) {
        return this.corredores.size() <= cantMax;
    }

    @Override
    public String toString() {
        return "CarreraAventura{" +
                "desnivel=" + desnivel +
                '}';
    }

    /**
     * Debe devolver un true si encuentra en la lista al menos un corredor con
     * al menos 5 puntos.
     */
    private boolean tenesCorredorConMasDeCincoPuntos() {

        boolean tieneCorredor = false;
        for (Corredor corredor : this.corredores) {
            if (corredor.getPuntaje() >= 5) {
                tieneCorredor = true;
            }
        }
        return tieneCorredor;
    }

    private boolean condicionDesnivelCumple() {
        return desnivel >= 2000;
    }

    @Override
    public boolean podesSerPatrocinado() {
        return this.tenesCorredorConMasDeCincoPuntos() || this.condicionDesnivelCumple();
    }


}
