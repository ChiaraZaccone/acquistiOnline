package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.model.Carrello;

public interface ICarrelloRepository extends CrudRepository <Carrello,Integer>{
	
 List<Carrello> findCarrelloByCodCliente(String cod_cliente);
 
 List <Carrello> findByCodArticolo(String cod_articolo);
	

}
