package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.model.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Integer>{

	Cliente findClienteByCodCliente(String cod_cliente);
}