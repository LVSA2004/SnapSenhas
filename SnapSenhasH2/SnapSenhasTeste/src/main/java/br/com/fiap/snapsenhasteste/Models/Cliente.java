package br.com.fiap.snapsenhasteste.Models;

import jakarta.persistence.*;

@Entity
@Table(name="tb_cliente")
public class Cliente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;
    @Column(name = "cl_nome")
    private String nome;
    @Column(name = "cl_telefone")
    private String telefone;
    @Column(name = "cl_email")
    private String email;
    @Column(name = "cl_login")
    private String login;
    @Column(name = "cl_senha")
    private String senha;

    public Cliente(){}

    public Cliente(Long id, String nome, String telefone, String email, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", login="
                + login + ", senha=" + senha + "]";
    }
}
