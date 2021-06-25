package be.digitalcity.formation.jeu.personnage.heros;

import be.digitalcity.formation.jeu.personnage.Personnage;

import java.util.HashMap;

public abstract class Heros extends Personnage {
    private HashMap<String,Integer> sacADos = new HashMap();

    public void rest(){
        this.pv = this.getEndurance() + modificateur(this.getEndurance());
        System.out.printf("Ton héro s'est reposé il est maintenant full PV !\n");
    }
}
