package carreras;

import corredores.Corredor;

public class CarreraCalle extends Carrera {

    public CarreraCalle(int distancia) {
        super(distancia);
    }

    @Override
    public void inscribir(Corredor unCorredor) {

        // validar la distancia, si es mayor pedir certificado
        if (this.distancia > 10 ) {
            if ( estaAutorizado(unCorredor) ) {
                incribirYActualizarCorredor(unCorredor);
            }
        } else {
            incribirYActualizarCorredor(unCorredor);
        }

    }

    @Override
    public boolean estaAutorizado(Corredor unCorredor) {
        return unCorredor.tieneCertificado();
    }

    /**
     * Metodo privado para tener en un único lugar la parte de actualizar
     * y hacer el código mucho mas claro.
     */
    private void incribirYActualizarCorredor(Corredor unCorredor) {
        this.corredores.add(unCorredor);
        unCorredor.actualizarDistancia(this.distancia);
        unCorredor.incrementarContadorCarreras();
    }


    /**
     * Solo pueden ser patrocinadas si cuentan con 100 o más corredores inscriptos
     */
    @Override
    public boolean podesSerPatrocinado() {
        return this.corredores.size() >= 100;
    }
}
