public class AvecChapeau extends PersonneDecorateur{
    public AvecChapeau(IPersonne personne) {
        super(personne);
    }

    @Override
    public String respirer() {
        return "avec mon chapeau";
    }

    @Override
    public String manger() {
        return "Arggggfgfjfhgf miam miam";
    }

    @Override
    public String sortir() throws PasHabilleException {
        return "Je sors avec mon chapeau";
    }
}