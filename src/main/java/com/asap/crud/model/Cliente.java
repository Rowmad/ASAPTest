package com.assement.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Data
@Document
public class Cliente {

    @Id
    private String cpf;

    private String nome;

    private String cidade;

    private String uf;

    @OneToMany(cascade = ALL)
    private List<Apolice> apolices;


    public void addApolice(Apolice apolice){
        apolices.add(apolice);
    }

    public void removeApolice(Apolice apolice){
        apolices.remove(apolice);
    }

}
