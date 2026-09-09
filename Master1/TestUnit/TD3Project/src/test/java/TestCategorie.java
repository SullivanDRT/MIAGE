import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.annotations.Test;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class TestCategorie {

    @Mock
    private Categorie categorie;

    @Test
    void testValCategorie1() {
        doReturn(1).when(categorie).valCategorie(Mockito.intThat(an -> an >= 0 && an <=10));
        Assertions.assertEquals(1, categorie.valCategorie(5));
    }
    @Test
    void testValCategorie2() {
        doReturn(2).when(categorie).valCategorie(Mockito.intThat(an -> an >= 11 && an <=20));
        Assertions.assertEquals( 1 , categorie.valCategorie(15));
    }
    @Test
    void testValCategorie3() {
        doReturn(1).when(categorie).valCategorie(Mockito.intThat(an -> an > 20));
        Assertions.assertEquals( 3, categorie.valCategorie(25));
    }




}
