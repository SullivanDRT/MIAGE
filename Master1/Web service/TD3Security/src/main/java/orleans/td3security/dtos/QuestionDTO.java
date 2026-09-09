package orleans.td3security.dtos;

import java.io.Serializable;

public class QuestionDTO implements Serializable {
    private String idQuestion;
    private int idUtilisateur;
    private String libelleQuestion;
    private String reponse;

    public QuestionDTO(String idQuestion, int idUtilisateur, String libelleQuestion, String reponse) {
        this.idQuestion = idQuestion;
        this.idUtilisateur = idUtilisateur;
        this.libelleQuestion = libelleQuestion;
        this.reponse = reponse;
    }

    public String getIdQuestion() {
        return idQuestion;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getLibelleQuestion() {
        return libelleQuestion;
    }

    public String getReponse() {
        return reponse;
    }
}
