package com.dobrychtop.desafiojava.resources;

import com.dobrychtop.desafiojava.entities.Endereco;
import com.dobrychtop.desafiojava.entitiesdto.EnderecoDTO;
import com.dobrychtop.desafiojava.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {


    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> aicionar(@RequestBody EnderecoDTO endereco) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.adicionar(endereco));
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listar() {
        List<Endereco> listar = enderecoService.listar();
        return ResponseEntity.ok().body(listar);
    }

    @GetMapping("pessoa/{id}")
    public ResponseEntity<List<Endereco>> EnderecosPessoa(@PathVariable Long id) {
        return ResponseEntity.ok().body(enderecoService.enderecoPorId(id));

    }

  //  @PutMapping("/pessoas/endereco-principal")
 //   public ResponseEntity<Endereco> definirEnderecoPrincipal(@RequestParam Long idPessoa,
                                                           //  @RequestParam Long idEndereco) {
     //   return ResponseEntity.ok().body(enderecoService.definirEnderecoPrincipal(idPessoa, idEndereco));
  //  }
}
