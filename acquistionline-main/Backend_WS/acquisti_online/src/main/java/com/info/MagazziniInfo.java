package com.info;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class MagazziniInfo {
	
	@JsonInclude(Include.NON_NULL)
	private int id;
	
	@JsonInclude(Include.NON_NULL)
	private String id_magazzino;
	
	@JsonInclude(Include.NON_NULL)
	private String qt_disponibile;
	
	@JsonInclude(Include.NON_NULL)
	private String cod_articolo;
	
	@JsonInclude(Include.NON_NULL)
	private String nome_articolo;
	
	@JsonInclude(Include.NON_NULL)
	private double prezzo_unitario;
	
	@JsonInclude(Include.NON_NULL)
	private String descrizione;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getId_magazzino() {
		return id_magazzino;
	}

	public void setId_magazzino(String id_magazzino) {
		this.id_magazzino = id_magazzino;
	}

	public String getQt_disponibile() {
		return qt_disponibile;
	}

	public void setQt_disponibile(String qt_disponibile) {
		this.qt_disponibile = qt_disponibile;
	}

	public String getCod_articolo() {
		return cod_articolo;
	}

	public void setCod_articolo(String cod_articolo) {
		this.cod_articolo = cod_articolo;
	}

	public String getNome_articolo() {
		return nome_articolo;
	}

	public void setNome_articolo(String nome_articolo) {
		this.nome_articolo = nome_articolo;
	}

	public double getPrezzo_unitario() {
		return prezzo_unitario;
	}

	public void setPrezzo_unitario(double prezzo_unitario) {
		this.prezzo_unitario = prezzo_unitario;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

}
