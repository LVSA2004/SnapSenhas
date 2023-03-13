package br.com.fiap.snapsenhas.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.snapsenhas.models.Cliente;

@RestController
public class ClienteController {
    @GetMapping("/api/cliente")
    public Cliente index(){

        Cliente cliente = new Cliente("Luan Sá","11959540882","lv9953420@gmail.com", "luan.sa", "@Fiap23" );
        return cliente;
    }
    
}
