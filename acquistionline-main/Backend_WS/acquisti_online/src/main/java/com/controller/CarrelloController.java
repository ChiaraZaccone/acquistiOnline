package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.errors.ExceptionResponse;
import com.errors.ResourceNotFound;
import com.info.CarrelloInfo;
import com.model.Carrello;
import com.service.ICarrelloService;
import com.service.IMagazziniService;

@RestController
@RequestMapping("acquistionline")
@CrossOrigin
public class CarrelloController {

	@Autowired
	private ICarrelloService serviceCarr;
	
	@Autowired
	private IMagazziniService serviceMag;

	// GetAll
	@GetMapping(value = "carrelli", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<CarrelloInfo>> getAllCarrelli() {
		List<Carrello> listCS = new ArrayList<>();
		List<CarrelloInfo> listI = new ArrayList<>();
		listCS = serviceCarr.getAllCarrelli();
		for (int i = 0; i < listCS.size(); i++) {
			CarrelloInfo ob = new CarrelloInfo();
			BeanUtils.copyProperties(listCS.get(i), ob);
			listI.add(ob);
		}
		return new ResponseEntity<List<CarrelloInfo>>(listI, HttpStatus.OK);
	}

	//GetAllCarrelliByCodCliente
	@GetMapping(value="carrelli/{codCliente}", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity <List<CarrelloInfo>> getAllCarrelliByCodCliente(@PathVariable ("codCliente") String codCliente){
		List<Carrello> listCS = new ArrayList<>();
		List<CarrelloInfo> listI = new ArrayList<>();
		listCS = serviceCarr.getAllCarrelliByCodCliente(codCliente);
		if(listCS.size()==0) {
			throw new ResourceNotFound("Non hai ancora effettutato gli ordini");
		}
		for (int i = 0; i < listCS.size(); i++) {
			CarrelloInfo ob = new CarrelloInfo();
			BeanUtils.copyProperties(listCS.get(i), ob);
			listI.add(ob);
		}
		return new ResponseEntity<List<CarrelloInfo>>(listI, HttpStatus.OK);
	}
	
	
	//add
	// si può aggiungere un carrello
	@PostMapping(value="carrello", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> addCarrello(@RequestBody CarrelloInfo info, UriComponentsBuilder builder){
		//posti disponibili per il volo
		Carrello obj = serviceMag.getAllCarrelliByCodCliente(info.getCod_articolo());
		int qtMax = obj.getQt_articoli();
		//biglietti già comprati per il volo		
		int articoliComprati = serviceCarr.getQtArticoli(info.getCod_articolo());
		int qtDaInserire = articoliComprati + info.getQt_articoli();
		if(qtDaInserire > qtMax) {
			int ArticoliDisp = qtMax - articoliComprati;
			if(ArticoliDisp != 0) {
				throw new ResourceNotFound("Disponibilità articolo"+info.getCod_cliente()+": "+ArticoliDisp);
			}else {
				throw new ResourceNotFound("Articolo "+info.getCod_cliente()+" non più disponibile");
		}
			}
				
		Carrello cr = new Carrello();
		BeanUtils.copyProperties(info, cr);
		boolean flag = serviceCarr.addCarrello(cr);
		if(!flag) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("carrello/{id}").buildAndExpand(cr.getId()).toUri());
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
		
		//si può aggiornare un carrello
		@PutMapping(value = "carrello", produces = { MediaType.APPLICATION_JSON_VALUE })
		public ResponseEntity<CarrelloInfo> updateCarrello(@RequestBody CarrelloInfo info){
			Carrello cr = new Carrello();
			BeanUtils.copyProperties(info, cr);
			CarrelloInfo crInfo = new CarrelloInfo();
			BeanUtils.copyProperties(cr, crInfo);
			if(!serviceCarr.existsById(crInfo.getId())) {
				return new ResponseEntity<CarrelloInfo>(crInfo,HttpStatus.NOT_FOUND);
			} 
			//posti disponibili per il volo
			int qtMax = serviceMag.getMagazziniByCodArticolo(info.getCod_articolo()).getQt_disponibile();    /*.getPostiDisp();*/
			//biglietti già comprati per il volo
			int articoliComprati = serviceCarr.getQtArticoli(info.getCod_articolo());
			
			int qtDaInserire = articoliComprati + info.getQt_articoli();
			if(qtDaInserire > qtMax) {
				int ArticoliDisp = qtMax - articoliComprati;
				if(ArticoliDisp != 0) {
					throw new ResourceNotFound("Disponibilità articolo"+info.getCod_cliente()+": "+ArticoliDisp);
				}else {
					throw new ResourceNotFound("Articolo "+info.getCod_cliente()+" non più disponibile");
			}
				}
			
				//ottengo la quantità dei biglietti già segnata sul db per quel codiceOperazione
				int qtCarrelliDb = serviceMag.getMagazziniByCodArticolo(info.getCod_articolo()).getQt_disponibile();
				//sommo il numero di biglietti aggiunti a qtBiglietti
				cr.setQt_articoli(info.getQt_articoli()+ qtCarrelliDb);
			
		
			serviceCarr.updateCarrello(cr);
			
			return new ResponseEntity<CarrelloInfo>(crInfo, HttpStatus.OK);
		}

	
	
	
	
	
}
