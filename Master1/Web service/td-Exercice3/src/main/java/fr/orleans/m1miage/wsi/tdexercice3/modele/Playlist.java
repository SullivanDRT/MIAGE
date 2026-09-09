package fr.orleans.m1miage.wsi.tdexercice3.modele;

import java.util.List;

public class Playlist {
    private String titre;
    private List<Video> videos;
    private Utilisateur auteur;
    public Playlist(List<Video> videos, Utilisateur auteur, String titre) {
        this.titre = titre;
        this.videos = videos;
        this.auteur = auteur;
    }
}
