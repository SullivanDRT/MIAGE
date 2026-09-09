import fr.orleans.m1miage.wsi.RechercheNombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestRechercheNombre {
    private final RechercheNombre rechercheNombre = new RechercheNombre();
    @Test
    public void testRechercheNombre() {
        List<Integer> liste = Arrays.asList(1, 2, 3, 4, 5);
        Integer result = rechercheNombre.rechercheNombreentier(3, liste);
        Assertions.assertEquals(2, result);
    }
    @Test
    public void testRechercheNombre2() {
        List<Integer> liste = Arrays.asList(1, 2, 3, 4, 5);
        Integer result = rechercheNombre.rechercheNombreentier(6, liste);
        Assertions.assertNull(result);
    }

}
