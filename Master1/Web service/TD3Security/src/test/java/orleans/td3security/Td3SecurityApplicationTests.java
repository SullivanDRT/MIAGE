package orleans.td3security;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import orleans.td3security.model.FacadeUtilisateurs;
import orleans.td3security.model.Utilisateur;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
@AutoConfigureMockMvc
class Td3SecurityApplicationTests {
    @Test
    public void testInscription() throws Exception{
        Utilisateur utilisateur = Mockito.mock(Utilisateur.class);
        doReturn(123).when(utilisateur).getIdUtilisateur();
        doReturn("toto").when(utilisateur).getLogin();


    }
}
