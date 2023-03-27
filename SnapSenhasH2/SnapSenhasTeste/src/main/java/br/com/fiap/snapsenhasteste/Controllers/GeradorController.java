package br.com.fiap.snapsenhasteste.Controllers;

import br.com.fiap.snapsenhasteste.Models.GeradorDeSenhas;
import br.com.fiap.snapsenhasteste.Repositories.GeradorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.*;

@RestController
@RequestMapping("snapsenhas/gerador")
public class GeradorController {
    Logger log = LoggerFactory.getLogger(GeradorController.class);
    @Autowired
    GeradorRepository repo;
    private static final String Letras_Maiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String Letras_Minusculas = "abcdefghijklmnopqrstuvwxyz";
    private static final String Numeros = "0123456789";
    private static final String Caracteres_Especiais = "!@#$%^&*()_+-=[]|,./?><";
    private static final String Todos_Caracteres =
            Letras_Maiusculas + Letras_Minusculas + Numeros + Caracteres_Especiais;

    @GetMapping
    public List<GeradorDeSenhas> index(){
        return repo.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<GeradorDeSenhas> show(@PathVariable Long id) {
        log.info("buscar senha com id: " + id);
        Optional<GeradorDeSenhas> senha = repo.findById(id);
        if (senha.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(senha.get());
    }

    @PostMapping
    public ResponseEntity<GeradorDeSenhas> create() {
        List<String> letras = Arrays.asList(Todos_Caracteres.split(""));
        Collections.shuffle(letras);
        SecureRandom random = new SecureRandom();
        StringBuilder senha = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int randomIndex = random.nextInt(letras.size());
            senha.append(letras.get(randomIndex));
        }
        GeradorDeSenhas geradorDeSenhas = new GeradorDeSenhas();
        geradorDeSenhas.setSenha(senha.toString());
        repo.save(geradorDeSenhas);
        return ResponseEntity.status(HttpStatus.CREATED).body(geradorDeSenhas);
    }

    @PutMapping("{id}")
    public ResponseEntity<GeradorDeSenhas> update(@PathVariable Long id, @RequestBody GeradorDeSenhas senhaAtualizado) {
        log.info("atualizar o senha com id: " + id);
        Optional<GeradorDeSenhas> senha = repo.findById(id);
        if (senha.isEmpty()) return ResponseEntity.notFound().build();
        BeanUtils.copyProperties(senhaAtualizado, senha.get(), "id");
        repo.save(senha.get());
        return ResponseEntity.ok(senha.get());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<GeradorDeSenhas> destroy(@PathVariable Long id) {
        log.info("deletar senha com o id: " + id);

        Optional<GeradorDeSenhas> senha = repo.findById(id);

        if (senha.isEmpty()) return ResponseEntity.notFound().build();

        repo.delete(senha.get());

        return ResponseEntity.noContent().build();
    }

    }

