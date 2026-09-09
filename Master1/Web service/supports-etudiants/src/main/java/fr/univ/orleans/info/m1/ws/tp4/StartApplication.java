package fr.univ.orleans.info.m1.ws.tp4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

import static fr.univ.orleans.info.m1.ws.tp4.controleur.ControleurServiceQuestionsReponses.getRoles;

@SpringBootApplication
public class StartApplication {


    @Autowired
    UserDetailsManager userDetailsManager;
    @Autowired
    PasswordEncoder passwordEncoder;


    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {

            UserDetails user1 = User.builder().username("anna.conda@univ-orleans.fr")
                    .password(passwordEncoder.encode("42andCounting"))
                            .roles(getRoles("anna.conda@univ-orleans.fr")).build();

            UserDetails user2 = User.builder().username("mouss.arazeh@etu.univ-orleans.fr")
                    .password(passwordEncoder.encode("1984"))
                            .roles(getRoles("mouss.arazeh@etu.univ-orleans.fr")).build();
        userDetailsManager.createUser(user1 );
            userDetailsManager.createUser(user2 );
        };
    }

    @Bean
    void changePassword(String oldPassword, String newPassword) {

    }

}
