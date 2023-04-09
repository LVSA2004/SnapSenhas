package br.com.fiap.snapsenhasteste.repositories;

import br.com.fiap.snapsenhasteste.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
