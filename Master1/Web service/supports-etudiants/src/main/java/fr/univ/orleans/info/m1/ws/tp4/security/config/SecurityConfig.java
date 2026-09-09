package fr.univ.orleans.info.m1.ws.tp4.security.config;

import fr.univ.orleans.info.m1.ws.tp4.modele.FacadeUser;
import fr.univ.orleans.info.m1.ws.tp4.modele.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Instant;
import java.util.function.Function;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    // Injection de dépendance via constructeur (l'injection via @Autowired sur attribut est dépréciée)
    @Value("${security.jwt.key.public}")
    RSAPublicKey rsaPublicKey;
    @Value("${security.jwt.key.private}")
    RSAPrivateKey rsaPrivateKey;
    @Value("${security.jwt.issuer}")
    String issuer;
    @Value("${security.jwt.expiration-minutes}")
    int expirationMinutes;

    /**
     * Configuration des permissions d'accès aux différentes URIs du WebService.
     */
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http, JwtDecoder decoder, JwtAuthenticationConverter jac) throws Exception {
        http.csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/api/utilisateurs").permitAll()
//                        .requestMatchers("/api/questions/**").hasRole(Role.ENSEIGNANT.name())
//                        .requestMatchers("/api/utilisateurs/**").hasRole(Role.ETUDIANT.name())
//                        .anyRequest().denyAll())
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt.decoder(decoder).jwtAuthenticationConverter(jac)));
        return http.build();
    }


    @Bean
    UserDetailsManager userDetailsManager() {
        return new FacadeUser();
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(this.rsaPublicKey).build();
    }

    @Bean
    JwtEncoder jwtEncoder() {
        JWK jwk = new RSAKey.Builder(this.rsaPublicKey).privateKey(this.rsaPrivateKey).build();
        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwks);
    }

    // Convertit la claim "roles" en autorités ROLE_*
    @Bean
    JwtAuthenticationConverter jwtAuthenticationConverter() {
        var conv = new JwtGrantedAuthoritiesConverter();
        conv.setAuthoritiesClaimName("roles");
        conv.setAuthorityPrefix("ROLE_");
        var jwtConv = new JwtAuthenticationConverter();
        jwtConv.setJwtGrantedAuthoritiesConverter(conv);
        return jwtConv;
    }

    @Bean
    Function<UserDetails,String> genereTokenFunction(JwtEncoder jwtEncoder) {
        return user -> {
            Instant now = Instant.now();
            var roles = user.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .map(a -> a.startsWith("ROLE_") ? a.substring(5) : a) // stocke sans préfixe
                    .toList();
            JwtClaimsSet claims = JwtClaimsSet.builder()
                    .issuer(issuer)
                    .issuedAt(now)
                    .expiresAt(now.plusSeconds(expirationMinutes*60))
                    .subject(user.getUsername())
                    .claim("roles", roles)
                    .build();
            return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        };
    }
}

