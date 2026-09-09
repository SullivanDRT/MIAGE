package fr.orleans.m1miage.wsi.tdexercice3.dtos;

import fr.orleans.m1miage.wsi.tdexercice3.modele.Utilisateur;

public class FabriqueDTO {
    public static UtilisateurDTO creerUtilisateurDTO(Utilisateur utilisateur) {
        UtilisateurDTO utilisateurDto = new UtilisateurDTO(utilisateur.getLogin(),utilisateur.getPassword());
        return utilisateurDto;
    }
}
