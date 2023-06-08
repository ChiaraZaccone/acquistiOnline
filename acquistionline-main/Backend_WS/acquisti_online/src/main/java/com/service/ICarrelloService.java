package com.service;

import java.util.List;

import com.model.Carrello;

public interface ICarrelloService {
	
	//getAll
	
	public List<Carrello> getAllCarrelli();
	
	//existById
	
	public boolean existsById(int id);
	
	//GetAllCarrelliByCodCliente
	
	public List <Carrello> getAllCarrelliByCodCliente(String codCliente);
	
	//addCarrello
	
	public boolean addCarrello (Carrello c);
	
	//updateCarrello
	
	public boolean updateCarrello (Carrello c);
	
	//getQntita
	
	public int getQtArticoli (String cod_articolo);
	
	
}
