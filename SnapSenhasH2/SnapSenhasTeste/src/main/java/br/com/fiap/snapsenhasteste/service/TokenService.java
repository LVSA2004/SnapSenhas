package br.com.fiap.snapsenhasteste.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import br.com.fiap.snapsenhasteste.models.Cliente;
import br.com.fiap.snapsenhasteste.repositories.ClienteRepository;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.snapsenhasteste.models.Credencial;
import br.com.fiap.snapsenhasteste.models.TokenJwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
@Service
public class TokenService {
    @Autowired
    ClienteRepository repo;
    public TokenJwt generateToken(Credencial credencial) {
        Algorithm alg = Algorithm.HMAC256("secret");
        var jwt = JWT.create()
                .withSubject(credencial.login())
                .withIssuer("Snap")
                .withExpiresAt(Instant.now().plus(20, ChronoUnit.MINUTES))
                .sign(alg)
                ;
        return new TokenJwt(jwt, "JWT", "Bearer");
    }

    public Cliente validate(String token) {
        Algorithm alg = Algorithm.HMAC256("secret");
        var email = JWT.require(alg)
                .withIssuer("Snap")
                .build()
                .verify(token)
                .getSubject();

        return repo.findByEmail(email).orElseThrow(
                () -> new JWTVerificationException("usuario nao encontrado"));

    }
}
