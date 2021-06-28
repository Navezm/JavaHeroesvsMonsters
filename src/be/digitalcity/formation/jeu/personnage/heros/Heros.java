package be.digitalcity.formation.jeu.personnage.heros;

import be.digitalcity.formation.jeu.personnage.Personnage;
import be.digitalcity.formation.jeu.utilitaire.Loots;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Heros extends Personnage implements Loots {

    List<Loots> sacADos = new ArrayList<>();

    public void rest() {
        this.pv = this.getEndurance() + modificateur(this.getEndurance());
        System.out.printf("Ton héro s'est reposé il est maintenant full PV !\n");
    }

    public void ramasserLoot(Personnage monstre){
        if(monstre.)
    }

}
