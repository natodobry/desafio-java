package com.dobrychtop.desafiojava.service;

import com.dobrychtop.desafiojava.entities.Endereco;
import com.dobrychtop.desafiojava.entities.Pessoa;
import com.dobrychtop.desafiojava.repository.PessoaRepository;
import com.dobrychtop.desafiojava.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa adicionar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscar(Long id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa enderecosPrincipalPorId(Long idPessoa, Long idEndereco) {
        Pessoa pessoa = pessoaRepository.findById(idPessoa).orElseThrow(() -> new ResourceNotFoundException("Pessoa nao encontrada com o id: " + idPessoa));
        for (Endereco endereco : pessoa.getEndereco()) {
            endereco.setEnderecoPrincipal(false);
            if (endereco.getId().equals(idEndereco)) {
                endereco.setEnderecoPrincipal(true);
            }
        }
        return pessoaRepository.save(pessoa);
    }
}
