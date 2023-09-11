package br.com.fiap.snapsenhasteste.models;

import jakarta.persistence.*;
import lombok.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="TB_CLIENTE")
public class Cliente implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Long id;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "SENHA")
    private String senha;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "ROLE_CLIENTE");
    }

    @Override
    public String getPassword() {

        return senha;
    }

    @Override
    public String getUsername() {

        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

