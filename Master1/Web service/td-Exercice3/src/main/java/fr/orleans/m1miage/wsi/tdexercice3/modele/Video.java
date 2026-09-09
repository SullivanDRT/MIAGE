package fr.orleans.m1miage.wsi.tdexercice3.modele;

public class Video {
    private String titre;
    private String lien;
    private Utilisateur createur;
    public Video(String titre, String lien, Utilisateur createur) {
        this.titre = titre;
        this.lien = lien;
        this.createur = createur;
    }
    public String getTitre() {
        return titre;
    }
    public String getLien() {
        return lien;
    }
    public Utilisateur getCreateur() {
        return createur;
    }
}
