package com.hygogg.ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hygogg.ninjas.models.Ninja;
import com.hygogg.ninjas.repositories.NinjaRepository;


@Service
public class NinjaService {

	private static NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public Ninja create(Ninja newNinja) {
		return ninjaRepo.save(newNinja);
	}
	
	public List<Ninja> getAll() {
		return (List<Ninja>) ninjaRepo.findAll();
	}
	
	public Ninja getOne(Long id) {
		Optional<Ninja> ninja = ninjaRepo.findById(id);
//		if(ninja.isPresent()) {
//			return ninja.get();
//		} else {
//			return null;
//		}
		return ninja.isPresent() ? ninja.get() : null;
	}
	
	public Ninja update(Ninja toUpdate, Long id) {
		return ninjaRepo.save(toUpdate);
	}
	
}
