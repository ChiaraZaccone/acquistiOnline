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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.MagazziniInfo;
import com.model.Magazzini;
import com.service.IMagazziniService;

@RestController
@RequestMapping("acquistionline")
@CrossOrigin

public class MagazziniController {
	
	@Autowired
	private IMagazziniService magazziniService;
	
	//Get All 
	
	@GetMapping(value="magazzini", produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<MagazziniInfo>> getAllMagazzini(){
		List<Magazzini> listMS=magazziniService.getAllMagazzini();
		List<MagazziniInfo> listMI= new ArrayList<MagazziniInfo>();
		for(int i=0; i<listMS.size();i++) {
			MagazziniInfo ob=new MagazziniInfo();
			BeanUtils.copyProperties(listMS.get(i), ob);
			listMI.add(ob);
		}
		
		return new ResponseEntity<List<MagazziniInfo>>(listMI,HttpStatus.OK);
	}
	

}
