package com.dobrychtop.desafiojava.entitiesdto;

import lombok.Data;

@Data
public class EnderecoDTO {

    private Long id;
    private String logradouro;
    private String cep;
    private Integer numero;
    private String cidade;
    private Long pessoaId;

}
