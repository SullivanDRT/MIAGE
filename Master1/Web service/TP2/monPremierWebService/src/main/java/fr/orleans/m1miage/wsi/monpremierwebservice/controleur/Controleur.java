package fr.orleans.m1miage.wsi.monpremierwebservice.controleur;


import fr.orleans.m1miage.wsi.monpremierwebservice.dtos.EtudiantDTO;
import fr.orleans.m1miage.wsi.monpremierwebservice.modele.Etudiant;
import fr.orleans.m1miage.wsi.monpremierwebservice.modele.FacadePromotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/mpws")
public class Controleur {
    FacadePromotion facadePromotion = new FacadePromotion();
    @PostMapping("/etudiant")
    public ResponseEntity<String> inscrireEtudiant(@RequestParam String nom, @RequestParam String prenom, @RequestParam String adresse) {
        String id = facadePromotion.enregistrerEtudiant(nom,prenom,adresse);
        return ResponseEntity.status(HttpStatus.CREATED).header("Location", id).body(id);
    }
    @GetMapping("etudiant/id")
    public ResponseEntity<EtudiantDTO> getEtudiant(@PathVariable String numeroEtudiant){
        facadePromotion.getEtudiantById(numeroEtudiant);
        return ResponseEntity.status(HttpStatus.CREATED).header()
    }
}
