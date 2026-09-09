package fr.orleans.m1miage.wsi.tdexercice3.modele;

import java.util.UUID;

public class Utilisateur {
    private String login;
    private String password;
    private String id;
    public Utilisateur(String login, String password) {
        this.login = login;
        this.password = password;
        this.id = UUID.randomUUID().toString();;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }

}
