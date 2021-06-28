package be.digitalcity.formation;

import be.digitalcity.formation.jeu.Jeu;
import be.digitalcity.formation.jeu.personnage.heros.Nain;
import be.digitalcity.formation.jeu.personnage.monstres.Dragonnet;
import be.digitalcity.formation.jeu.personnage.monstres.Loup;
import be.digitalcity.formation.jeu.personnage.monstres.Orque;

public class Main {

    public static void main(String[] args) {
        Nain nain = new Nain();
        Dragonnet dragonnet = new Dragonnet();
        Loup loup = new Loup();
        Orque orque = new Orque();

        System.out.println("Nain pv :"+nain.getPv() + " endurance : "+nain.getEndurance());
        System.out.println("Dragonnet "+dragonnet.getPv());


//        Jeu.combat(nain, dragonnet);
//        System.out.println(nain.getPv());
//
//        nain.rest();
//
//        Jeu.combat(nain, loup);
//        System.out.println(nain.getPv());
//
//        nain.rest();
//
//        Jeu.combat(nain, orque);
//        System.out.println(nain.getPv());

        System.out.println(dragonnet.getOr()+ " " + dragonnet.getCuir());
    }
}
