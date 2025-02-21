package be.digitalcity.formation;

import be.digitalcity.formation.jeu.Jeu;
import be.digitalcity.formation.jeu.personnage.heros.Nain;
import be.digitalcity.formation.jeu.personnage.monstres.*;

public class Main {

    public static void main(String[] args) {
        Nain nain = new Nain();
        Dragonnet dragonnet = new Dragonnet(4,5);
        Loup loup = new Loup(4,3);
        Orque orque = new Orque(8,1);

        System.out.println("Nain pv :"+nain.getPv() + " endurance : "+nain.getEndurance());
        System.out.println("Dragonnet "+dragonnet.getPv());

        Jeu.combat(nain, dragonnet);

        Jeu.combat(nain, loup);

        Jeu.combat(nain, orque);
    }
}
