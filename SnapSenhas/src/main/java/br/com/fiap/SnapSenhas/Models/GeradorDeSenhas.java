package br.com.fiap.SnapSenhas.Models;

import org.springframework.stereotype.Component;

@Component
public class GeradorDeSenhas {
    private String senha;
    private Long id;
    
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

}
