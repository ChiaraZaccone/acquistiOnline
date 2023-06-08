package com.service;

import java.util.List;

import com.model.Carrello;
import com.model.Magazzini;

public interface IMagazziniService {
	
	//get All
	
	public List<Magazzini> getAllMagazzini();
	
	//get by ID
	
	public Magazzini getMagazziniById(int id);
	
	//exist by ID
	
	public boolean existById(int id);
	
	//public Magazzini  getMagazziniByCodArticolo(String codArticolo);
	
    Carrello getAllCarrelliByCodCliente(String codCliente);
    
    Magazzini getMagazziniByCodArticolo(String codArticolo);


	
	

}
