package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Cliente;
import com.repository.IClienteRepository;

@Service
public class ClienteService implements IClienteService{

	@Autowired
	private IClienteRepository clientrepo;

	@Override
	public List<Cliente> getAllClienti() {
		List<Cliente> cList = new ArrayList<>();
		clientrepo.findAll().forEach(c->cList.add(c));
		return cList;
	}

	@Override
	public Cliente getClienteByCodCliente(String codCliente) {
	    Cliente cliente = new Cliente();
	    cliente = clientrepo.findClienteByCodCliente(codCliente);
		return cliente;
	}

	@Override
	public boolean existsClienteByCodCliente(String codCliente) {
		
		boolean exists = false;
        
        if(clientrepo.findClienteByCodCliente(codCliente) == null) {
        	exists = false;
        
        } else {
       exists = true;
        }
		return exists;
	}



	
}