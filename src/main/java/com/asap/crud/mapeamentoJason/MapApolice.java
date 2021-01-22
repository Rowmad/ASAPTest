package com.asap.crud.mapeamentoJason;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MapApolice {

    @JsonProperty("numero")
    private int numero;

    @JsonProperty("inicioVigencia")
    private String inicioVigencia;

    @JsonProperty("fimVigencia")
    private String fimVigencia;

    @JsonProperty("placa")
    private String placa;

    @JsonProperty("valor")
    private double valor;
}
