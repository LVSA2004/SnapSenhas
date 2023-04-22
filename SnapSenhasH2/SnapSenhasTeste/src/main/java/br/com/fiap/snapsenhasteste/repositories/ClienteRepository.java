package br.com.fiap.snapsenhasteste.repositories;

import br.com.fiap.snapsenhasteste.models.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE LOWER(c.nome) LIKE LOWER(CONCAT('%', :nome, '%')) ORDER BY c.nome DESC")
    Page<Cliente> findByNome(@Param("nome") String nome, Pageable pageable);
}
