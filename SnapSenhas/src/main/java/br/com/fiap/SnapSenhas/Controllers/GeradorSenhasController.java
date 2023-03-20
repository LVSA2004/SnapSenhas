package br.com.fiap.SnapSenhas.Controllers;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.SnapSenhas.Models.GeradorDeSenhas;

@RestController
public class GeradorSenhasController {
    private static final String Letras_Maiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String Letras_Minusculas = "abcdefghijklmnopqrstuvwxyz";
    private static final String Numeros = "0123456789";
    private static final String Caracteres_Especiais = "!@#$%^&*()_+-=[]|,./?><";
    private static final String Todos_Caracteres =
    Letras_Maiusculas + Letras_Minusculas + Numeros + Caracteres_Especiais;

    private List<String> senhas = new ArrayList<>();

    // Exibe as senhas Criadas
    @GetMapping("/gerador-senhas")
    public GeradorDeSenhas gerarSenha() {
        GeradorDeSenhas geradordesenhas = new GeradorDeSenhas();
        String senha = gerarSenhaAleatoria();
        senhas.add(senha);
        geradordesenhas.setSenha(senha);
        return geradordesenhas;
    }

    // Cria as senhas 
    private String gerarSenhaAleatoria() {
        List<String> letras = Arrays.asList(Todos_Caracteres.split(""));
        Collections.shuffle(letras);
        SecureRandom random = new SecureRandom();
        StringBuilder senha = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int randomIndex = random.nextInt(letras.size());
            senha.append(letras.get(randomIndex));
        }
        return senha.toString();
    }

    // Lista as Senhas
    @GetMapping("/listagem")
    public List<String> listarSenhas() {
        return senhas;
    }

    // Deleta as Senhas Existentes
    @DeleteMapping("/gerador-senhas/{id}")
    public GeradorDeSenhas excluirSenha(@PathVariable int id) {
        if (id >= 0 && id < senhas.size()) {
            String senhaExcluida = senhas.remove(id);
            GeradorDeSenhas geradordesenhas = new GeradorDeSenhas();
            geradordesenhas.setSenha(senhaExcluida);
            return geradordesenhas;
        } else {
            return null;
        }
    }

    //Atualiza as Senhas Existentes
    @PutMapping("/gerador-senhas/{id}")
    public GeradorDeSenhas atualizarSenha(@PathVariable int id, @RequestBody GeradorDeSenhas senhaAtualizada) {
        if (id >= 0 && id < senhas.size()) {
            senhas.set(id, senhaAtualizada.getSenha());
            return senhaAtualizada;
        } else {
            return null;
        }
    }
}
