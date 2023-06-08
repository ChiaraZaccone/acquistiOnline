package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Carrello;
import com.model.Magazzini;
import com.repository.IMagazziniRepository;

@Service

public class MagazziniService implements IMagazziniService {
	
	@Autowired
	private IMagazziniRepository repo;

	@Override
	public List<Magazzini> getAllMagazzini() {
		List <Magazzini> lst=new ArrayList<>();
		
		repo.findAll().forEach(mz->lst.add(mz));
		return lst;
	}

	@Override
	public Magazzini getMagazziniById(int id_magazzino) {
		return repo.findById(id_magazzino).get();
	}

	@Override
	public boolean existById(int id_magazzino) {
		return repo.existsById(id_magazzino);
	}

	@Override
	public Magazzini getMagazziniByCodArticolo(String codArticolo) {
 
		Magazzini magazzini= new Magazzini();
		magazzini= repo.findBycodArticolo(codArticolo);
		return magazzini;
	}

	@Override
	public Carrello getAllCarrelliByCodCliente(String codCliente) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	

}
