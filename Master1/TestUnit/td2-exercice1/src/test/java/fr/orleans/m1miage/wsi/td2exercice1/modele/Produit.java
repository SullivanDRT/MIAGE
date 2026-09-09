package fr.orleans.m1miage.wsi.td2exercice1.modele;

public class Produit {
    private int id;
    private String categorie;
    private double prix;
    public Produit(int id, String categorie, double prix) {
        this.id = id;
        this.categorie = categorie;
        this.prix = prix;
    }
    public double getPrix() {
        return prix;
    }

    public String getCategorie() {
        return categorie;
    }
    public int getId() {
        return id;
    }
}
