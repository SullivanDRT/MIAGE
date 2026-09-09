package exercice2.formules;

import exercice2.formules.constantes.Faux;
import exercice2.formules.constantes.Inconnu;
import exercice2.formules.constantes.Vrai;
import exercice2.formules.operateurs.Et;
import exercice2.formules.operateurs.Negation;

public class Visiteur implements IVisiteur{


    @Override
    public void visiter(Negation neg) {

    }

    @Override
    public void visiter(Et et) {

    }

    @Override
    public void visiter(Vrai vrai) {

    }

    @Override
    public void visiter(Inconnu inconnu) {

    }

    @Override
    public void visiter(Faux faux) {

    }
}
