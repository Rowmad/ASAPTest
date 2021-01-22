package com.assement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;


@Data
@Document
public class Apolice {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int numero;

    private String inicioVigencia;

    private String fimVigencia;

    private String placa;

    private double valor;

}
