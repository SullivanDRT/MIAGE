package exercice2.formules;

public abstract class Formule implements Element {
     public void accept(IVisiteur visiteur){
        visiteur.visiter(this);
    }
}
