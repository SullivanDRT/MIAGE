public class Personne implements IPersonne {
    public String nom;
    public Personne(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }
    @Override
    public String respirer() {
        return "respire";
    }

    @Override
    public String manger() {
        return "mange";
    }

    @Override
    public String sortir() throws PasHabilleException {
        throw new PasHabilleException();
    }
}
