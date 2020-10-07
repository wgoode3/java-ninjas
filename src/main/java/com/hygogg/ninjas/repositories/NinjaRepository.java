package com.hygogg.ninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hygogg.ninjas.models.Ninja;


@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {}
