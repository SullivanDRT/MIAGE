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

@ExtendWith(MockitoExtension.class)
public class TestMockitoExercice1 {
    @Mock
    private Produit produitCategorie1;
    @Mock
    private Produit produitCategorie2;
    @Mock
    private Produit produitCategorie3;
    @Mock
    private Panier panier1;

    @Test
    public void getTotalsProduits() {
        doReturn
        Set<Produit> produits = Set.of(produitCategorie1, produitCategorie2, produitCategorie3);

    }

    @Test
    public void getTotalsProduitsInconnue() {
        panier1.ajouterProduit(new Produit(4,"catégorie 4", 10));
        Assertions.assertThrows(CategorieIncconueException.class,() -> panier1.getPrixTotal());
    }

}

