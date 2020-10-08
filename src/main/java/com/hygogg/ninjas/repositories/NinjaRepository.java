package com.hygogg.ninjas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hygogg.ninjas.models.Ninja;


@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	
	@Query(value="SELECT * FROM ninjas ORDER BY level DESC LIMIT 3", nativeQuery=true)
	List<Ninja> top3NinjasWoah();
	
}
