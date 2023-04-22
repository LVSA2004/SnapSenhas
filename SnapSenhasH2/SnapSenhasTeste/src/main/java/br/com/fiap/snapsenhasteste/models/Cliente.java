package br.com.fiap.snapsenhasteste.models;

import br.com.fiap.snapsenhasteste.controllers.ClienteController;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import java.util.List;

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

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GeradorDeSenhas> senhas;

    public EntityModel<Cliente> toModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(ClienteController.class).show(id)).withSelfRel(),
                linkTo(methodOn(ClienteController.class).destroy(id)).withRel("delete"),
                linkTo(methodOn(ClienteController.class).index(Pageable.unpaged())).withRel("all")
        );
    }
}

