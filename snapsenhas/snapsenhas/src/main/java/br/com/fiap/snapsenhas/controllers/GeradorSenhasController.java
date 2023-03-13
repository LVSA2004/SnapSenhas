package br.com.fiap.snapsenhas.controllers;

import br.com.fiap.snapsenhas.models.GeradorDeSenhas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class GeradorSenhasController {

    private static final String Letras_Maiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String Letras_Minusculas = "abcdefghijklmnopqrstuvwxyz";
    private static final String Numeros = "0123456789";
    private static final String Caracteres_Especiais = "!@#$%^&*()_+-=[]|,./?><";
    private static final String Todos_Caracteres =
    Letras_Maiusculas + Letras_Minusculas + Numeros + Caracteres_Especiais;

    @GetMapping("/gerador-senhas")
    public GeradorDeSenhas gerarSenha() {
        GeradorDeSenhas geradordesenhas = new GeradorDeSenhas();
        geradordesenhas.setSenha(gerarSenhaAleatoria());
        return geradordesenhas;
    }

    private String gerarSenhaAleatoria() {
        List<String> letras = Arrays.asList(Todos_Caracteres.split(""));
        Collections.shuffle(letras);
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(letras.size());
            password.append(letras.get(randomIndex));
        }
        return password.toString();
    }
    
}
