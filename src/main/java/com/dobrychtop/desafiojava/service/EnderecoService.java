package com.dobrychtop.desafiojava.service;

import com.dobrychtop.desafiojava.entities.Endereco;
import com.dobrychtop.desafiojava.entities.Pessoa;
import com.dobrychtop.desafiojava.entitiesdto.EnderecoDTO;
import com.dobrychtop.desafiojava.repository.EnderecoRepository;
import com.dobrychtop.desafiojava.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Endereco adicionar(EnderecoDTO enderecoDTO) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(enderecoDTO.getPessoaId());
        Endereco endereco = new Endereco();
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setCep(enderecoDTO.getCep());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setPessoa(pessoa.get());
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> listar() {
        return enderecoRepository.findAll();
    }

    public List<Endereco> enderecoPorId(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        Pessoa pessoa1 = pessoa.get();
        return pessoa1.getEndereco();
    }
}
