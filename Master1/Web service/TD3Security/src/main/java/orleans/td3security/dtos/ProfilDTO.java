package orleans.td3security.dtos;

import java.io.Serializable;

public class ProfilDTO implements Serializable {
    public int id;
    public String email;

    public ProfilDTO(int id, String email) {
        this.id = id;
        this.email = email;
    }
    public ProfilDTO() {
    }
    //get et set

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
