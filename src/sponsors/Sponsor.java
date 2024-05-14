package sponsors;


import java.util.HashSet;

public class Sponsor {

    private HashSet<Patrocinable> patrocinados = new HashSet<>();

    public void patrocinar(Patrocinable cualquierCosaSponsoreable) {

        if (cualquierCosaSponsoreable.podesSerPatrocinado()) {
            patrocinados.add(cualquierCosaSponsoreable);
        }

    }

}
