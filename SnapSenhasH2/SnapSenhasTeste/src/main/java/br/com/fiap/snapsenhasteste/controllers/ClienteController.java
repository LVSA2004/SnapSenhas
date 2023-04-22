package br.com.fiap.snapsenhasteste.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.fiap.snapsenhasteste.models.Cliente;
import br.com.fiap.snapsenhasteste.repositories.ClienteRepository;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;

//Indica que esta classe é um controlador Spring que lida com solicitações HTTP.
@RestController
//Define o controlador que irá lidar com solicitações para o caminho "/snapsenhas/cliente" na aplicação web.
@RequestMapping("snapsenhas/cliente")
public class ClienteController {

    //Cria um objeto Logger para registrar informações e erros em log.
    Logger log = LoggerFactory.getLogger(ClienteController.class);

    //Injeta uma instância da interface "ClienteRepository" que lida com as operações do banco de dados para a entidade Cliente.
    @Autowired
    ClienteRepository repo;
    @Autowired
    PagedResourcesAssembler<Cliente> assembler;

    //Define um método que responde a solicitações GET para o caminho "/snapsenhas/cliente".
    // O método chama o método "findAll()" na instância "ClienteRepository" e retorna todos os clientes armazenados no banco de dados.
    @GetMapping
    public PagedModel<EntityModel<Cliente>>  index(@PageableDefault(size = 5) Pageable pageable){
        return assembler.toModel(repo.findAll(pageable));
    }
    //O método cria um objeto Pageable com base nos parâmetros "page" e "size" recebidos e usa o método findByNome do repositório (repo) para pesquisar
    // e retornar uma página (Page) de objetos Cliente que tenham o nome correspondente ao valor do parâmetro "nome".
    @GetMapping("/pesquisa")
    public Page<Cliente> search(@RequestParam String nome,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return repo.findByNome(nome, pageable);
    }

    //Define um método que responde a solicitações GET para o caminho "/snapsenhas/cliente/{id}",
    // onde {id} é um parâmetro que representa o ID do cliente que está sendo solicitado.
    //O método chama o método "findById()" na instância "ClienteRepository"
    //e retorna um objeto ResponseEntity que contém o cliente correspondente ou um erro 404 se o cliente não existir no banco de dados.
    @GetMapping("{id}")
    public EntityModel<Cliente> show(@PathVariable Long id) {
        log.info("buscar cliente com id: " + id);
        Cliente cliente = repo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        return cliente.toModel();
    }

    //Define um método que responde a solicitações POST para o caminho "/snapsenhas/cliente".
    //O método cria um novo cliente a partir dos dados fornecidos no corpo da solicitação HTTP
    // e chama o método "save()" na instância ClienteRepository para persistir o cliente no banco de dados.
    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody @Valid Cliente cliente) {
        log.info("cadastrar cliente: " + cliente);
        repo.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //Define um método que responde a solicitações PUT para o caminho "/snapsenhas/cliente/{id}", onde {id} é o ID do cliente que está sendo atualizado.
    //O método chama o método "findById()" na instância  "ClienteRepository" para recuperar o cliente existente,
    // copia as propriedades atualizadas do cliente atualizado para o cliente existente
    // e chama o método "save()" na instância ClienteRepository para persistir as alterações no banco de dados.
    @PutMapping("{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody @Valid Cliente clienteAtualizado) {
        log.info("atualizar o cliente com id: " + id);
        Cliente cliente = repo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
        BeanUtils.copyProperties(clienteAtualizado, cliente, "id");
        repo.save(cliente);
        return ResponseEntity.ok(cliente);
    }
    //Define um método que responde a solicitações DELETE para o caminho "/snapsenhas/cliente/{id}", onde {id} é o ID do cliente que está sendo excluído.
    //O método chama o método "findById()" na instância de "ClienteRepository" para recuperar
    // cliente existente e chama o método "delete()" no "ClienteRepository"para excluí-lo do banco de dados.
    @DeleteMapping("{id}")
    public ResponseEntity<Cliente> destroy(@PathVariable Long id) {
        log.info("deletar cliente com o id: " + id);
        Cliente cliente = repo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));;
        repo.delete(cliente);
        return ResponseEntity.noContent().build();
    }
    // Anotações que definem um manipulador de exceção para erros de validação de dados. Se ocorrer uma exceção do tipo "ConstraintViolationException",
    // o método "handleValidationExceptions()" será chamado para registrar o erro e retornar uma resposta HTTP 400 (Bad Request) com a mensagem de erro.
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleValidationExceptions(ConstraintViolationException ex) {
        log.error("Erro de validação: ", ex);
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    //Anotações que definem um manipulador de exceção para erros gerais do servidor, se ocorrer uma exceção do tipo.
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAllExceptions(Exception ex) {
        log.error("Erro não esperado: ", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro inesperado. Tente novamente mais tarde.");
    }
}
