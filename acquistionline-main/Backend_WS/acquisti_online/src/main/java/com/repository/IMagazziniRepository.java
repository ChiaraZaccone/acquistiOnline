package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Magazzini;

@Repository
public interface IMagazziniRepository  extends CrudRepository<Magazzini, Integer> {
	
	Magazzini findBycodArticolo(String cod_articolo);
	
	
	//boolean existsByIdMagazzino(String id_magazzino);
	

}
