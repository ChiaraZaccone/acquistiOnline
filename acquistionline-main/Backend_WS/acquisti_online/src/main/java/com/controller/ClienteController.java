package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.errors.ResourceNotFound;
import com.info.ClienteInfo;
import com.model.Cliente;
import com.service.IClienteService;

@RestController
@RequestMapping(value="acquistionline")
@CrossOrigin
public class ClienteController {

	@Autowired
	private IClienteService clientservice;
	
	//Restituisce tutti i clienti registrati sul db
	@GetMapping(value="clienti", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<ClienteInfo>> getAllClienti(){
		List<Cliente> clienti = new ArrayList<>();
		List<ClienteInfo> listInfo = new ArrayList<>();
		clienti = clientservice.getAllClienti();
		for(int i=0;i<clienti.size();i++) {
			ClienteInfo clienteInfo = new ClienteInfo();
			BeanUtils.copyProperties(clienti.get(i), clienteInfo);
			listInfo.add(clienteInfo);
		}
		return new ResponseEntity<List<ClienteInfo>>(listInfo,HttpStatus.OK);
	}
	
	//Restituisce il cliente con codCliente corrispondente
	@GetMapping(value="cliente/{codCliente}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ClienteInfo> getClienteById(@PathVariable("codCliente") String codCliente){
		Cliente cliente = new Cliente();
		if(!clientservice.existsClienteByCodCliente(codCliente)) {
			throw new ResourceNotFound("Cliente con cod :" + codCliente + " non disponibile");
		}
		cliente = clientservice.getClienteByCodCliente(codCliente);
		ClienteInfo cInfo = new ClienteInfo();
		BeanUtils.copyProperties(cliente, cInfo);
		
		return new ResponseEntity<ClienteInfo>(cInfo, HttpStatus.OK);
		
	}
	
}