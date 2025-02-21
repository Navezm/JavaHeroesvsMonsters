package be.digitalcity.formation.jeu.personnage.heros;

import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.personnage.monstres.*;
import be.digitalcity.formation.jeu.utilitaire.Cuir;
import be.digitalcity.formation.jeu.utilitaire.Loots;

import java.util.ArrayList;
import java.util.List;

public abstract class Heros extends Personnage implements Loots {

    private final List<Loots> sacADos = new ArrayList<>();

    public void getContenuSacADos() {
        int nombreCuir = 0;
        int nombreOr = 0;
        for (Loots loot: sacADos) {
            if (loot instanceof Cuir) {
                nombreCuir ++;
            } else {
                nombreOr ++;
            }
        }
        System.out.printf("Ton sac à dos contient %d Cuir et %d Or\n", nombreCuir, nombreOr);
    }

    public void rest() {
        this.pv = this.getEndurance() + modificateur(this.getEndurance());
        System.out.printf("Ton héro s'est reposé il a maintenant %d PV !\n", this.pv);
    }

    public void ramasserLoot(Personnage monstre){
        if (monstre instanceof Loup){
            sacADos.addAll(((Loup)monstre).getCuir());
            System.out.println("Bravo tu as récupéré " + ((Loup)monstre).getCuir().size() + " cuir !");
        } else if (monstre instanceof Orque){
            sacADos.addAll(((Orque)monstre).getOr());
            System.out.println("Bravo tu as récupéré " + ((Orque)monstre).getOr().size() + " or !");
        } else {
            sacADos.addAll((((Dragonnet)monstre)).getOr());
            sacADos.addAll((((Dragonnet)monstre)).getCuir());
            System.out.println("Bravo tu as récupéré " + ((Dragonnet)monstre).getOr().size() + " or !");
            System.out.println("Bravo tu as récupéré " + ((Dragonnet)monstre).getCuir().size() + " cuir !");
        }
    }

}
