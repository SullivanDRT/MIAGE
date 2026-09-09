package fr.orleans.m1miage.wsi.tdexercice3.controleur;


import fr.orleans.m1miage.wsi.tdexercice3.dtos.FabriqueDTO;
import fr.orleans.m1miage.wsi.tdexercice3.dtos.UtilisateurDTO;
import fr.orleans.m1miage.wsi.tdexercice3.exceptions.LoginDejaPrisException;
import fr.orleans.m1miage.wsi.tdexercice3.modele.Facade;
import fr.orleans.m1miage.wsi.tdexercice3.modele.Utilisateur;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/mpl")
public class Controleur {
    private Facade facade;
    public Controleur(Facade facade) {
        this.facade = facade;
    }
    @PostMapping("/utilisateur")
    public ResponseEntity<String> creerUtilisateur( @RequestBody UtilisateurDTO utilisateur, UriComponentsBuilder uriComponentsBuilder) {

        try {
            String id = facade.inscription(utilisateur);
            URI uri = uriComponentsBuilder.path("/mpl/utilisateur/{id}").buildAndExpand(id).toUri();
            return  ResponseEntity.created(uri).build();

        } catch (LoginDejaPrisException e) {
            return ResponseEntity.status(409).body("Conflit de login");
        }
    }
    @GetMapping("/utilisateur/{id}")
    public ResponseEntity<UtilisateurDTO> getUtilisateur(@PathVariable String id) {
        Utilisateur util = facade.consultationUtilisateur(id);
        return ResponseEntity.ok(FabriqueDTO.creerUtilisateurDTO(util));
    }
}
