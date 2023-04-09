package br.com.fiap.snapsenhasteste.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="tb_cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cliente {
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
}

