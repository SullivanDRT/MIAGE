package fr.univ.orleans.info.m1.ws.tp4.modele;

import fr.univ.orleans.info.m1.ws.tp4.controleur.ControleurServiceQuestionsReponses;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.HashMap;
import java.util.Map;

public class FacadeUser implements UserDetailsManager {

    private Map<String,UserDetails> users;

    private PasswordEncoder passwordEncoder;

    public FacadeUser() {
        this.users = new HashMap<>();
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void createUser(UserDetails user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public void updateUser(UserDetails user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public void deleteUser(String username) {
        users.remove(username);
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        UserDetails u = loadUserByUsername(currentUser);
        UserDetails newuser = User.builder()
                .username(u.getUsername())
                .password(newPassword)
                .roles(ControleurServiceQuestionsReponses.getRoles(u.getUsername()))
                .build();
        if(!oldPassword.equals(newPassword)){
            this.updateUser(newuser);
        }
    }

    @Override
    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.get(username);
    }
}
