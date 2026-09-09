package operations;

import modele.exceptions.NonSupporteeException;
import modele.operations.Operations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.doReturn;


@ExtendWith(MockitoExtension.class)
public class TestOp {

    @Spy
    private Operations op;

    @Mock
    private Operations nextOp;

    @Test
    void testOpResultatNextNull(){
        doReturn("Somme").when(op).getNomOperation();
        doReturn(null).when(op).getNext();
        Assertions.assertThrows(modele.exceptions.NonSupporteeException.class, () -> {
            op.getResultat("Soustraction", 5, 3);
        });
    }
    @Test
    void testOpResultat() throws NonSupporteeException {
        doReturn("Somme").when(op).getNomOperation();
        Assertions.assertEquals(8, op.getResultat("Somme",5,3));
    }
    @Test
    void testOpGetResultatWithNext() throws NonSupporteeException {
        doReturn("Somme").when(op).getNomOperation();
        doReturn(nextOp).when(op).getNext();
        doReturn(2).when(nextOp).getResultat("Soustraction",5,3);
        Assertions.assertEquals(2, op.getResultat("Soustraction",5,3));
    }
}






