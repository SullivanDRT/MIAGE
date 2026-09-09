package exercice2.formules.operateurs;

import exercice2.formules.Formule;
import exercice2.formules.IVisiteur;

public class Et extends Formule {

    private Formule gauche;
    private Formule droite;

    public Et(Formule gauche, Formule droite) {
        this.gauche = gauche;
        this.droite = droite;
    }

    public Formule getGauche() {
        return gauche;
    }

    public Formule getDroite() {
        return droite;
    }
}
