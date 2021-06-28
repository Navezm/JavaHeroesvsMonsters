package be.digitalcity.formation.jeu.personnage.heros;

import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.personnage.monstres.Dragonnet;
import be.digitalcity.formation.jeu.personnage.monstres.Loup;
import be.digitalcity.formation.jeu.personnage.monstres.Orque;
import be.digitalcity.formation.jeu.utilitaire.Cuir;
import be.digitalcity.formation.jeu.utilitaire.Loots;

import java.util.ArrayList;
import java.util.List;

public abstract class Heros extends Personnage implements Loots {

    public List<Loots> sacADos = new ArrayList<>();

    public void rest() {
        this.pv = this.getEndurance() + modificateur(this.getEndurance());
        System.out.printf("Ton héro s'est reposé il est maintenant full PV !\n");
    }

    public void ramasserLoot(Personnage monstre){
        if (monstre instanceof Loup){
            sacADos.add(((Cuir)monstre));
            System.out.println("Bravo tu as récupéré " + (Loup)monstre.getCuir() + " cuir !");
        } else if (monstre instanceof Orque){
            sacADos.add((Orque)monstre.getOr());
            System.out.println("Bravo tu as récupéré " + (Orque)monstre.getOr() + " or !");
        } else {
            sacADos.add((Dragonnet)monstre.getOr());
            sacADos.add((Dragonnet)monstre.getCuir());
            System.out.println("Bravo tu as récupéré " + (Dragonnet)monstre.getOr() + " or !");
            System.out.println("Bravo tu as récupéré " + (Dragonnet)monstre.getCuir() + " cuir !");
        }
    }

}
