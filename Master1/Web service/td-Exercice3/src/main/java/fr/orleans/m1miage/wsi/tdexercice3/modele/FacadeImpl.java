package fr.orleans.m1miage.wsi.tdexercice3.modele;

import fr.orleans.m1miage.wsi.tdexercice3.dtos.UtilisateurDTO;
import fr.orleans.m1miage.wsi.tdexercice3.exceptions.LoginDejaPrisException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class FacadeImpl implements Facade{
    private final HashSet<Utilisateur> utilisateurs = new HashSet<>();
    private List<Video> videos;
    @Override
    public String inscription(UtilisateurDTO utilisateur) throws LoginDejaPrisException {
        for(Utilisateur util : utilisateurs){
            if(util.getLogin().equals(utilisateur.getLogin())){
                throw new LoginDejaPrisException();
            }
        }
        Utilisateur utilRegister = new Utilisateur(utilisateur.getLogin(), utilisateur.getPassword());
        String id = utilRegister.getId();
        utilisateurs.add(utilRegister);
        return id;
    }


    @Override
    public Utilisateur consultationUtilisateur(String id) {
        for(Utilisateur utilisateur : utilisateurs){
            if(utilisateur.getId().equals(id)){
                return utilisateur;
            }
        }
        return null;
    }

    @Override
    public List<Video> recupererListVideoUtilisateur(Utilisateur utilisateur) {
        List<Video> videosUtilisateur = new ArrayList<>();
        for (Video video : videos){
            if(video.getCreateur().getLogin().equals(utilisateur.getLogin())){
                videosUtilisateur.add(video);
            }
        }
        return videosUtilisateur;
    }

    @Override
    public Playlist creePlaylist(Utilisateur utilisateur, String titre) {
        return null;
    }
}
