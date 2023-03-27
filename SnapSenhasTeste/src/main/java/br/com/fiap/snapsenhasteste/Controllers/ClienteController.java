package br.com.fiap.snapsenhasteste.Controllers;
import br.com.fiap.snapsenhasteste.Models.Cliente;
import br.com.fiap.snapsenhasteste.Repositories.ClienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("snapsenhas/cliente")
public class ClienteController {
    Logger log = LoggerFactory.getLogger(ClienteController.class);
    @Autowired
    ClienteRepository repo;
    @GetMapping
    public List<Cliente> index(){
        return repo.findAll();
    }
    @GetMapping("{id}")
    public ResponseEntity<Cliente> show(@PathVariable Long id) {
        log.info("buscar cliente com id: " + id);

        Optional<Cliente> cliente = repo.findById(id);

        if (cliente.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(cliente.get());
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        log.info("cadastrar cliente: " + cliente);

        repo.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        log.info("atualizar o cliente com id: " + id);

        Optional<Cliente> cliente = repo.findById(id);

        if (cliente.isEmpty()) return ResponseEntity.notFound().build();

        BeanUtils.copyProperties(clienteAtualizado, cliente.get(), "id");

        repo.save(cliente.get());

        return ResponseEntity.ok(cliente.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cliente> destroy(@PathVariable Long id) {
        log.info("deletar cliente com o id: " + id);

        Optional<Cliente> cliente = repo.findById(id);

        if (cliente.isEmpty()) return ResponseEntity.notFound().build();

        repo.delete(cliente.get());

        return ResponseEntity.noContent().build();
    }
}
