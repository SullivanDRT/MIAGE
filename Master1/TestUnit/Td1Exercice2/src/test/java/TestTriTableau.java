import org.example.TriTableau;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class TestTriTableau {
    private TriTableau triTableau;
    @BeforeEach
    public void setUp() {
        triTableau = getInstance();
    }
    public abstract TriTableau getInstance();
    @Test
    public void listeTrierPositif() {
        Assertions.assertArrayEquals(triTableau.trier(new int[]{1,5,2,4,3}), new int[]{1,2,3,4,5});
    }
    @Test
    public void listeTrierNegatif() {
        Assertions.assertArrayEquals(triTableau.trier(new int[]{-1,-5,-2,-4,-3}), new int[]{-5,-4,-3,-2,-1});
    }
    @Test
    public void listeTrier() {
        Assertions.assertArrayEquals(triTableau.trier(new int[]{1,2,3,4,5}), new int[]{1,2,3,4,5});
    }
    @Test
    public void listeTrierPosEtNeg() {
        Assertions.assertArrayEquals(triTableau.trier(new int[]{-1,-5,-2,-4,-3, 10,5}), new int[]{-5,-4,-3,-2,-1,5,10});
    }
    @Test
    public void listeTrierPair(){
        Assertions.assertArrayEquals(triTableau.trier(new int[]{1,5,2,4}), new int[]{1,2,4,5});
    }
    @Test
    public void listeTrierImpair(){
        Assertions.assertArrayEquals(triTableau.trier(new int[]{1,5,2,4,15}), new int[]{1,2,4,5,15});
    }
    @Test
    public void listeTrierUnSeulElement(){
        Assertions.assertArrayEquals(triTableau.trier(new int[]{1}), new int[]{1});
    }
    @Test
    public void listeTrierVide(){
        Assertions.assertArrayEquals(triTableau.trier(new int[]{}), new int[]{});
    }
    @Test
    public void listeTrierNull(){
        Assertions.assertArrayEquals(triTableau.trier(null), null);
    }
}
