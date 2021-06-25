package be.digitalcity.formation.jeu.personnage;

import be.digitalcity.formation.jeu.De;

public abstract class Personnage {
    private int force;
    private int endurance;
    protected int pv;

    // Déclaration stats de bases
    public Personnage(){

    }

    public int getForce() {
        return force;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int frappe(){
        // Dmg = Lancé dé 4 face + modificateur basé sur force
        int damage = De.lancerDe(4) + modificateur(this.force);
        return damage;
    }

    // Modificateur basé sur un stat
    public int modificateur(int stat){
        int modificateur = 0;
        if (stat < 5){
            modificateur -= 1;
        } else if (stat > 10 && stat < 15) {
            modificateur += 1;
        } else if (stat > 15){
            modificateur += 2;
        }
        return modificateur;
    }
}
