package jpa.jpa.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.persistence.EntityNotFoundException;
import jpa.jpa.dominio.Pessoa;
import jpa.jpa.repositorio.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public void salvarPessoa(@RequestBody Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }

    public void atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada) {
        Pessoa pessoaExistente = buscarPorId(id);

        if (pessoaExistente != null) {
            pessoaExistente.setNome(pessoaAtualizada.getNome());
            pessoaExistente.setCpf(pessoaAtualizada.getCpf());
            pessoaExistente.setSobrenome(pessoaAtualizada.getSobrenome());
            pessoaExistente.setEmail(pessoaAtualizada.getEmail());
            pessoaExistente.setTelefones(pessoaAtualizada.getTelefones());

            pessoaRepository.save(pessoaExistente);
        } else {
            throw new EntityNotFoundException("Pessoa não encontrada com o ID: " + id);
        }
    }

    public List<Pessoa> buscarTodas() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscarPorId(Long id) {
        Optional<Pessoa> Optionalpessoa = pessoaRepository.findById(id);
        return Optionalpessoa.orElse(null);
    }

    public void deletarPorId(Long id) {
        pessoaRepository.deleteById(id);
    }

    public void verifyIfExists(Long id) {
        Optional<Pessoa> Optionalpessoa = pessoaRepository.findById(id);
        if (!Optionalpessoa.isPresent()) {
            throw new EntityNotFoundException("Pessoa não encontrada com o ID: " + id);
        }
    }

}
