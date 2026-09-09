package exercice2.formules;

import exercice2.formules.constantes.Faux;
import exercice2.formules.constantes.Inconnu;
import exercice2.formules.constantes.Vrai;
import exercice2.formules.operateurs.Et;
import exercice2.formules.operateurs.Negation;

public interface IVisiteur {

    public void visiter(Negation neg);
    public void visiter(Et et);
    public void visiter(Vrai vrai);
    public void visiter(Inconnu inconnu);
    public void visiter(Faux faux);
}
