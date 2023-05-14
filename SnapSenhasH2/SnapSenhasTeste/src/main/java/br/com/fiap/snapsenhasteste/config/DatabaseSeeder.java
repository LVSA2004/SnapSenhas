package br.com.fiap.snapsenhasteste.config;

import br.com.fiap.snapsenhasteste.models.Cliente;
import br.com.fiap.snapsenhasteste.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {
    @Autowired
    ClienteRepository repo;
    @Override
    public void run(String... args) throws Exception {
        Cliente cl1 = Cliente.builder()
                .nome("Luan Sá")
                .telefone("(11) 959540882")
                .email("lvssfiap@gmail.com")
                .login("luan_sa")
                .senha("rm93057")
                .build();
        Cliente cl2 = Cliente.builder()
                .nome("André Santi")
                .telefone("(11) 959180722")
                .email("santificado@gmail.com")
                .login("snt")
                .senha("rm94327")
                .build();
        Cliente cl3 = Cliente.builder()
                .nome("Gabriel Henrique")
                .telefone("(11) 987654321")
                .email("ainzedamanga@gmail.com")
                .login("monoqiyana")
                .senha("rm94430")
                .build();
        Cliente cl4 = Cliente.builder()
                .nome("Henrique Alves")
                .telefone("(11) 987650882")
                .email("SORIYEEEE@gmail.com")
                .login("empurra_mole")
                .senha("rm95725")
                .build();


        repo.saveAll(List.of(
                cl1, cl2, cl3, cl4
        ));



    }
}