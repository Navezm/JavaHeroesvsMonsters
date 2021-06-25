package be.digitalcity.formation.jeu.utilitaire;

public final class De {
    public static int lancerDe(int face){
        int resultat = 0;
        switch (face) {
            case 4:
                resultat = 1 + (int)(Math.random() * ((4 - 1) + 1));
                break;
            case 6:
                resultat = 1 + (int)(Math.random() * ((6 - 1) + 1));
                break;
        }
        return resultat;
    }
}
