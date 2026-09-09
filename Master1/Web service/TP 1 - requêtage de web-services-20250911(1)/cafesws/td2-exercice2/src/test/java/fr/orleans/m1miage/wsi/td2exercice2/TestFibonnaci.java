package fr.orleans.m1miage.wsi.td2exercice2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


@ExtendWith(MockitoExtension.class)
public class TestFibonnaci {
    @Spy
    private Fibonnacci fibo;

    @Test
    public void testFibonnaci(){
        doReturn(3).when(fibo).calculFibonnaci(3);
        doReturn(2).when(fibo).calculFibonnaci(2);
        Assertions.assertEquals(8, fibo.calculFibonnaci(4));
    }
}
