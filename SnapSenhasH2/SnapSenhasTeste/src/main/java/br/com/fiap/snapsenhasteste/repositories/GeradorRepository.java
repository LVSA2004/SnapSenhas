package br.com.fiap.snapsenhasteste.repositories;

import br.com.fiap.snapsenhasteste.models.GeradorDeSenhas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeradorRepository extends JpaRepository<GeradorDeSenhas, Long> {
    Page<GeradorDeSenhas> findBySenhaContainingIgnoreCase(String senha, Pageable pageable);
}
