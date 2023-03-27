package br.com.fiap.snapsenhasteste.Repositories;

import br.com.fiap.snapsenhasteste.Models.GeradorDeSenhas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeradorRepository extends JpaRepository<GeradorDeSenhas, Long> {
}
