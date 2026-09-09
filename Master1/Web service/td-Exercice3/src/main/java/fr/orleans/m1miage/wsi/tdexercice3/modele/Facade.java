package fr.orleans.m1miage.wsi.tdexercice3.modele;

import fr.orleans.m1miage.wsi.tdexercice3.dtos.UtilisateurDTO;
import fr.orleans.m1miage.wsi.tdexercice3.exceptions.LoginDejaPrisException;

import java.util.List;

public interface Facade {
    public String inscription(UtilisateurDTO utilisateur) throws LoginDejaPrisException;
    public Utilisateur consultationUtilisateur(String id);
    public List<Video> recupererListVideoUtilisateur(Utilisateur utilisateur);
    public Playlist creePlaylist(Utilisateur utilisateur, String titre);
}
