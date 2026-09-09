package fr.orleans.m1miage.wsi.td2exercice1.test;

import fr.orleans.m1miage.wsi.td2exercice1.modele.CategorieIncconueException;
import fr.orleans.m1miage.wsi.td2exercice1.modele.Panier;
import fr.orleans.m1miage.wsi.td2exercice1.modele.Produit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

public class TestStructurelsExercice1 {
    private Panier panier1;

    @BeforeEach
    public void setUp() {
        panier1 = new Panier();
    }
    @Test
    public void getTotalsProduits() {
        Produit p1 = new Produit(1, "catégorie 1", 10);
        Produit p2 = new Produit(2, "catégorie 2", 10);
        panier1.ajouterProduit(p1);
        panier1.ajouterProduit(p2);
        System.out.println(panier1.getPrixTotal());
        Assertions.assertEquals(20, panier1.getPrixTotal());
    }

    @Test
    public void getTotalsProduitsInconnue() {
        panier1.ajouterProduit(new Produit(4,"catégorie 4", 10));
        Assertions.assertThrows(CategorieIncconueException.class,() -> panier1.getPrixTotal());
    }

}
