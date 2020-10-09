package com.hygogg.ninjas.services;

import org.springframework.stereotype.Service;

import com.hygogg.ninjas.models.Technique;
import com.hygogg.ninjas.repositories.TechniqueRepository;


@Service
public class TechniqueService {

	private static TechniqueRepository techRepo;
	
	public TechniqueService(TechniqueRepository techRepo) {
		this.techRepo = techRepo;
	}
	
	public Technique create(Technique newTech) {
		return techRepo.save(newTech);
	}
	
}
