public class FashionWeek {
    public static void main(String[] args) {
        IPersonne cindy = new Personne("Cindy");
        cindy = new AvecChapeau(cindy);
        System.out.println(cindy.manger());
        System.out.println(cindy.respirer());
        try {
            System.out.println(cindy.sortir());
        } catch (PasHabilleException e) {
            e.printStackTrace();
        }
    }
}
