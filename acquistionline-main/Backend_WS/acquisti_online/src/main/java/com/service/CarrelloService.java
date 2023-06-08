package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Carrello;
import com.repository.ICarrelloRepository;

@Service
public class CarrelloService implements ICarrelloService{
	
	@Autowired
	private ICarrelloRepository repo;

	@Override
	public List<Carrello> getAllCarrelli() {
		List <Carrello> lst= new ArrayList<>();
		
		repo.findAll().forEach(cr->lst.add(cr));
		return lst;
	}

	@Override
	public boolean existsById(int id) {
		return repo.existsById(id);
	}

	@Override
	public List<Carrello> getAllCarrelliByCodCliente(String codCliente) {
		List<Carrello> lst= new ArrayList<>();
		lst= repo.findCarrelloByCodCliente(codCliente);
		return lst;
	}

	@Override
	public boolean addCarrello(Carrello c) {
		if(repo.existsById(c.getId())) {
			return false;	
		}else {
			repo.save(c);
			return true;
		}
		
	}

	@Override
	public boolean updateCarrello(Carrello c) {
		boolean flag = repo.existsById(c.getId());
		if(!flag) {
			return false;
		}
			
		repo.save(c);
		return true;
	}

	@Override
	public int getQtArticoli(String cod_articolo) {
		List<Carrello> carrelloarticoli= repo.findByCodArticolo(cod_articolo);
		int qtArticoliComprati= 0;
		for(Carrello carrello: carrelloarticoli) {
			qtArticoliComprati += carrello.getQt_articoli();
		}
		return qtArticoliComprati;
	}
	
	
	

}
