package jpa.jpa.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import jpa.jpa.dominio.Pessoa;
import jpa.jpa.repositorio.PessoaRepository;

@Service 
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;  

    public void salvarPessoa(@RequestBody Pessoa pessoa){
        pessoaRepository.save(pessoa);
    }

    public List<Pessoa> buscarTodas() {
        return pessoaRepository.findAll();
    }
}
