package br.com.fiap.snapsenhasteste.models;

import br.com.fiap.snapsenhasteste.controllers.ClienteController;
import br.com.fiap.snapsenhasteste.controllers.GeradorController;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Entity
@Table(name = "tb_gerador")
@Getter
@Setter
public class GeradorDeSenhas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_senha")
    private Long id;

    @Column(name = "gd_senha")
    private String senha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public EntityModel<GeradorDeSenhas> toModel() {
        return EntityModel.of(
                this,
                linkTo(methodOn(GeradorController.class).show(id)).withSelfRel(),
                linkTo(methodOn(GeradorController.class).destroy(id)).withRel("delete"),
                linkTo(methodOn(GeradorController.class).index(Pageable.unpaged())).withRel("all")
        );
    }
}