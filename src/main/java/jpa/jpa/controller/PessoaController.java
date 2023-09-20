package jpa.jpa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jpa.jpa.dominio.Pessoa;
import jpa.jpa.repositorio.PessoaRepository;
import jpa.jpa.servicos.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    
    @Autowired
    private PessoaService pessoaService;  

    @PostMapping("/salvar")
    public void salvarPessoa(@RequestBody Pessoa pessoa){
        pessoaService.salvarPessoa(pessoa);
    }

    @GetMapping("/buscar")
    public List<Pessoa> buscarTodas() {
        return pessoaService.buscarTodas();
    }

    @GetMapping("/ola")
    public String getOla() {
        return "Olá mundo!";
    }
}
