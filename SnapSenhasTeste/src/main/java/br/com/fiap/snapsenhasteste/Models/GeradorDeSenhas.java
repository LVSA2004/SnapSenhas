package br.com.fiap.snapsenhasteste.Models;

import jakarta.persistence.*;

@Entity
@Table(name="tb_gerador")
public class GeradorDeSenhas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_senha")
    private Long id;
    @Column(name = "gd_senha")
    private String senha;

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
