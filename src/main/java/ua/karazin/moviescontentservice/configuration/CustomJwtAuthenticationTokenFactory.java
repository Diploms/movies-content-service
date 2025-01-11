package ua.karazin.moviescontentservice.configuration;

import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.ArrayList;
import java.util.Collection;

public class CustomJwtAuthenticationTokenFactory {
    public static JwtAuthenticationToken createToken(@NotBlank Jwt jwt) {
        return new JwtAuthenticationToken(jwt, extractAuthorities(jwt));
    }

    private static Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
        // TODO
        return new ArrayList<>();
    }
}
