package orleans.td3security.control;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import orleans.td3security.dtos.InscriptionDTO;
import orleans.td3security.dtos.ProfilDTO;
import orleans.td3security.dtos.QuestionDTO;
import orleans.td3security.exception.LoginDejaUtiliseException;
import orleans.td3security.model.FacadeApplication;
import orleans.td3security.model.FacadeUtilisateurs;
import orleans.td3security.model.Utilisateur;

@RestController
@RequestMapping("/api")
public class ControleurForum {

    FacadeUtilisateurs facadeUtilisateurs;
    FacadeApplication facadeApplication;
    PasswordEncoder passwordEncoder;

    public ControleurForum(FacadeUtilisateurs facadeUtilisateurs, PasswordEncoder passwordEncoder, FacadeApplication facadeApplication) {
        this.facadeUtilisateurs = facadeUtilisateurs;
        this.passwordEncoder = passwordEncoder;
        this.facadeApplication = facadeApplication;
    }

    @PostMapping("/utilisateur")
    public ResponseEntity<ProfilDTO> inscription(@RequestBody InscriptionDTO inscriptionDTO, UriComponentsBuilder uri) {
        try {
            int id = facadeUtilisateurs.inscrireUtilisateur(
                    inscriptionDTO.getEmail(),
                    passwordEncoder.encode(inscriptionDTO.getMotDePasse()));
            var url = uri.path("/utilisateur/{id}").buildAndExpand(id).toUri();
            return ResponseEntity.created(url).body(new ProfilDTO(
                    id,
                    inscriptionDTO.getEmail()
            ));
        } catch (LoginDejaUtiliseException e) {
            return ResponseEntity.status(409).build();
        }
    }

    @PostMapping("/utilisateur/{idUtil}/question")
    public ResponseEntity<QuestionDTO> ajouterQuestion(@PathVariable String idUtil, @RequestBody QuestionDTO questionDTO, UriComponentsBuilder uri){
            String idQuestion = facadeApplication.ajouterUneQuestion(Integer.parseInt(idUtil), questionDTO.getIdQuestion());
            var url = uri.path("/utilisateur/{idUtil}/question/{idQuest}").buildAndExpand(idQuestion).toUri();
            return ResponseEntity.created(url).body(questionDTO);
    }
}
