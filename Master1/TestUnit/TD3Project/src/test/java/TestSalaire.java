import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


@ExtendWith(MockitoExtension.class)
public class TestSalaire {
    @Spy
    private Employe employe;
    @Mock
    private Categorie categorie;

    @Test
    public void testSalaire() {
    doReturn(categorie).when(employe).creerCategorie();
    doReturn(1).when(categorie).valCategorie(Mockito.intThat(an -> an >=0 && an <=10));
    doReturn(3000.0).when(employe).getSalaireDeBase();
    Assertions.assertEquals(3000.0, employe.getSalaireDeBase());
    }
    @Test
    public void testSalaire2() {
        doReturn(categorie).when(employe).creerCategorie();
        doReturn(1).when(categorie).valCategorie(Mockito.intThat(an -> an >=0 && an <=10));
        doReturn(3000.0).when(employe).getSalaireDeBase();
        Assertions.assertEquals(3000.0, employe.getSalaireDeBase());
    }
    @Test
    public void testSalaire3() {
        doReturn(categorie).when(employe).creerCategorie();
        doReturn(1).when(categorie).valCategorie(Mockito.intThat(an -> an >=0 && an <=10));
        doReturn(3000.0).when(employe).getSalaireDeBase();
        Assertions.assertEquals(3000.0, employe.getSalaireDeBase());
    }

}
