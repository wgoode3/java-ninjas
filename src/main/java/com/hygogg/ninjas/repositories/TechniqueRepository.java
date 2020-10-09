package com.hygogg.ninjas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hygogg.ninjas.models.Technique;


public interface TechniqueRepository extends CrudRepository<Technique, Long> {}
