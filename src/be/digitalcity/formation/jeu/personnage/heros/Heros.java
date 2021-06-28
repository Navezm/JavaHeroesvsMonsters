package be.digitalcity.formation.jeu.personnage.heros;

import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.personnage.monstres.Monstre;
import be.digitalcity.formation.jeu.utilitaire.Loots;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Heros extends Personnage implements Loots {

    public List<Loots> sacADos = new ArrayList<>();

    public void rest() {
        this.pv = this.getEndurance() + modificateur(this.getEndurance());
        System.out.printf("Ton héro s'est reposé il est maintenant full PV !\n");
    }

    public void ramasserLoot(Monstre monstre){
        if (monstre.getClass().getSimpleName().equals("Loup")){
            sacADos.add(monstre.getCuir());
            System.out.println("Bravo tu as récupéré " + monstre.getCuir() + " cuir !");
        } else if (monstre.getClass().getSimpleName().equals("Orque")){
            sacADos.add(monstre.getOr());
            System.out.println("Bravo tu as récupéré " + monstre.getOr() + " or !");
        } else {
            sacADos.add(monstre.getOr());
            sacADos.add(monstre.getCuir());
            System.out.println("Bravo tu as récupéré " + monstre.getOr() + " or !");
            System.out.println("Bravo tu as récupéré " + monstre.getCuir() + " cuir !");
        }
    }

}
