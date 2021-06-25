package be.digitalcity.formation.jeu.personnage.heros;

import be.digitalcity.formation.jeu.personnage.Personnage;

import java.util.HashMap;

public class Heros extends Personnage {
    private HashMap<String,Integer> sacADos = new HashMap();

    public void rest(){
        this.pv = this.getEndurance() + modificateur(this.getEndurance());
    }
}
