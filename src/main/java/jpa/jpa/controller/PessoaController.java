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

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    
    @Autowired
    private PessoaRepository pessoaRepository;  

    @PostMapping
    public void salvarPessoa(@RequestBody Pessoa pessoa){
        pessoaRepository.save(pessoa);
    }

    @GetMapping("/buscar")
    public List<Pessoa> buscarTodas() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/ola")
    public String getOla() {
        return "Olá mundo!";
    }
}
