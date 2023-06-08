package com.service;

import java.util.List;

import com.model.Cliente;

public interface IClienteService {

	public List<Cliente> getAllClienti();
	
	public Cliente getClienteByCodCliente(String codCliente);
	
	public boolean existsClienteByCodCliente(String codCliente);
}