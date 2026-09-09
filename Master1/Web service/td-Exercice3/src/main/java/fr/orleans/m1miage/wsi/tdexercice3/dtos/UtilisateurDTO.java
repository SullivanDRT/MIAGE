package fr.orleans.m1miage.wsi.tdexercice3.dtos;

import java.io.Serializable;


public class UtilisateurDTO implements Serializable {
    private String login;
    private String password;

    public UtilisateurDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }
}
