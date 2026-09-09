package fr.orleans.m1miage.wsi.td2exercice1.modele;

import java.util.HashSet;
import java.util.Set;

public class Panier {
    private Set<Produit> produits;

    public Panier() {
        this.produits = new HashSet<>();
    }

    public Set<Produit> getProduits() {
        return produits;
    }

    public double getPrixTotal() throws CategorieIncconueException {
        double total = 0;
        for (Produit p : getProduits()) {
            switch (p.getCategorie()) {
                case "catégorie 1":
                    total += p.getPrix() * 0.5;
                    break;
                case "catégorie 2":
                    total += p.getPrix() * 0.8;
                    break;
                case "catégorie 3":
                    total += p.getPrix() * 0.3;
                    break;
                default:
                    throw new CategorieIncconueException();
            }
        }
        return total;
    }

    public void ajouterProduit(Produit p) throws CategorieIncconueException {
        produits.add(p);
    }
}
