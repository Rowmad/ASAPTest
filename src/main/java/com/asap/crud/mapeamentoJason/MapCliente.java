package com.assement.mapeamentoJason;

import com.assement.model.Apolice;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MapCliente {

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("cidade")
    private String cidade;

    @JsonProperty("uf")
    private String uf;

    @JsonProperty("apolices")
    private ArrayList<Apolice> apolices;
}
