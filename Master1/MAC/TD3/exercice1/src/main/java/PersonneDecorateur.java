public abstract class PersonneDecorateur implements IPersonne{
    private IPersonne personne;
    public PersonneDecorateur(IPersonne personne) {
        this.personne = personne;
    }
    @Override
    public String respirer() {
        return "je respire";
    }

    @Override
    public String manger() {
        return "Je mange";
    }

    @Override
    public String sortir() throws PasHabilleException {
        return "Je sors";
    }
}