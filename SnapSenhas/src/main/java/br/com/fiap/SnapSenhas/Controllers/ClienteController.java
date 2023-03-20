package br.com.fiap.SnapSenhas.Controllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.SnapSenhas.Models.Cliente;

@RestController
public class ClienteController {
    private List<Cliente> clientes = new ArrayList<>();

    @GetMapping
    public List<Cliente> listarClientes(){
        return clientes;
    }
    
    @GetMapping("/api/cliente")
    public Cliente index(){

        Cliente cliente = new Cliente("Luan Sá","11959540882","lv9953420@gmail.com", "luan.sa", "@Fiap23" );
        return cliente;
    }

    @PostMapping
    public void cadastrarCliente(@RequestBody Cliente cliente){
        clientes.add(cliente);
    }

    @DeleteMapping("/{id}")
    public void apagarCliente(@PathVariable int id){
        clientes.remove(id);
    }

    @PutMapping("/{id}")
    public void atualizarCliente(@PathVariable int id, @RequestBody Cliente cliente){
        clientes.set(id, cliente);
    }
    
}
