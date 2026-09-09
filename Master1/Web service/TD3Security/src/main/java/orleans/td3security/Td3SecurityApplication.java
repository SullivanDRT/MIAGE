package orleans.td3security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import orleans.td3security.model.FacadeUtilisateurs;

@SpringBootApplication
public class Td3SecurityApplication {

    FacadeUtilisateurs facadeUtilisateurs;
    PasswordEncoder passwordEncoder;

    public Td3SecurityApplication(FacadeUtilisateurs facadeUtilisateurs, PasswordEncoder passwordEncoder) {
        this.facadeUtilisateurs = facadeUtilisateurs;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
        SpringApplication.run(Td3SecurityApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            facadeUtilisateurs.inscrireUtilisateur("yohan.boichut@univ-orleans.fr",
                    passwordEncoder.encode("monMotDePasse"));
            facadeUtilisateurs.inscrireUtilisateur("gerard.menvussaa@etu.univ-orleans.fr",
                    passwordEncoder.encode("sonMotDePasse"));
        };
    }
}
