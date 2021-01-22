package com.asap.crud.repository;


import com.assement.model.Apolice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ApoliceRepository extends MongoRepository<Apolice, Integer> {
}
