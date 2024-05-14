package carreras;

import corredores.Corredor;

public class CarreraRecreativa extends Carrera {

    public CarreraRecreativa(int distancia) {
        super(distancia);
    }

    public void inscribir(Corredor unCorredor) {
        corredores.add(unCorredor);
    }

    @Override
    public boolean estaAutorizado(Corredor unCorredor) {
        return true;
    }

    @Override
    public boolean podesSerPatrocinado() {
        return false;
    }
}
