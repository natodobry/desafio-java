package com.dobrychtop.desafiojava.resources;

import com.dobrychtop.desafiojava.entities.Pessoa;
import com.dobrychtop.desafiojava.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> aicionar(@RequestBody Pessoa pessoa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.adicionar(pessoa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscar(@PathVariable Long id) {
        Optional<Pessoa> buscar = pessoaService.buscar(id);
        if (buscar.isPresent()) {
            return ResponseEntity.ok(buscar.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar(@RequestBody Pessoa pessoa,
                                            @PathVariable Long id) {
        Optional<Pessoa> pessoaAtual = pessoaService.buscar(id);
        if (pessoaAtual.isPresent()) {
            BeanUtils.copyProperties(pessoa, pessoaAtual.get(), "id");
            return ResponseEntity.ok(pessoaService.adicionar(pessoaAtual.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listar() {
        List<Pessoa> listar = pessoaService.listar();
        return ResponseEntity.ok().body(listar);
    }

    @PutMapping(path ="/endereco-principal")
    public ResponseEntity<Pessoa> definirEnderecoPrincipal(@RequestParam Long idPessoa,
                                                           @RequestParam Long idEndereco) {
        return ResponseEntity.ok().body(pessoaService.enderecosPrincipalPorId(idPessoa, idEndereco));
    }

}
