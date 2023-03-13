package br.com.fiap.snapsenhas.models;

import org.springframework.stereotype.Component;

@Component
public class GeradorDeSenhas {
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}