package br.com.fiap.snapsenhasteste.Repositories;

import br.com.fiap.snapsenhasteste.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
