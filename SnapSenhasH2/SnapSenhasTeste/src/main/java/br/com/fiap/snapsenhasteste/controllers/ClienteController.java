package br.com.fiap.snapsenhasteste.controllers;

import br.com.fiap.snapsenhasteste.models.Credencial;
import br.com.fiap.snapsenhasteste.service.TokenService;
import br.com.fiap.snapsenhasteste.models.Cliente;
import br.com.fiap.snapsenhasteste.repositories.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {
    @Autowired
    ClienteRepository repo;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    TokenService tokenService;

    @PostMapping("/snapsenhas/cadastro")
    public ResponseEntity<Cliente> registrar(@RequestBody Cliente cliente) {
        cliente.setSenha(encoder.encode(cliente.getSenha()));
        repo.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @PostMapping("/snapsenhas/login")
    public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial) {
        manager.authenticate(credencial.toAuthentication());
        var token = tokenService.generateToken(credencial);

        return ResponseEntity.ok(token);
    }

}
