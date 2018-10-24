
package com.andersonbco.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.andersonbco.api.model.Planeta;

public interface PlanetaRepository extends MongoRepository<Planeta, String> {

}
