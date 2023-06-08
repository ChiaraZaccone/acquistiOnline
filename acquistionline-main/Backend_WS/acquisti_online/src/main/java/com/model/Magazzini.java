package com.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="magazzini")
public class Magazzini {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="id_magazzino")
	private String idmagazzino;
	
	@Column(name="qt_disponibile")
	private int qt_disponibile;
	
	@Column(name="cod_articolo")
	private String codArticolo;
	
	@Column(name="nome_articolo")
	private String nome_articolo;
	
	@Column(name="prezzo_unitario")
	private double prezzo_unitario;
	
	@Column (name="descrizione")
	private String descrizione;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getId_magazzino() {
		return idmagazzino;
	}

	public void setId_magazzino(String id_magazzino) {
		this.idmagazzino = id_magazzino;
	}

	public int getQt_disponibile() {
		return qt_disponibile;
	}

	public void setQt_disponibile(int qt_disponibile) {
		this.qt_disponibile = qt_disponibile;
	}

	public String getCod_articolo() {
		return codArticolo;
	}

	public void setCod_articolo(String cod_articolo) {
		this.codArticolo = cod_articolo;
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
	
	@Override
	public int hashCode() {
	    return Objects.hash(idmagazzino, qt_disponibile, codArticolo, nome_articolo, prezzo_unitario, descrizione);
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
	        return true;
	    if (obj == null || getClass() != obj.getClass())
	        return false;
	    Magazzini other = (Magazzini) obj;
	    return Objects.equals(idmagazzino, other.idmagazzino) &&
	            qt_disponibile == other.qt_disponibile &&
	            Objects.equals(codArticolo, other.codArticolo) &&
	            Objects.equals(nome_articolo, other.nome_articolo) &&
	            Double.compare(prezzo_unitario, other.prezzo_unitario) == 0 &&
	            Objects.equals(descrizione, other.descrizione);
	}

	@Override
	public String toString() {
	    return "Magazzini [id=" + id + ", id_magazzino=" + idmagazzino + ", qt_disponibile=" + qt_disponibile +
	            ", cod_articolo=" + codArticolo + ", nome_articolo=" + nome_articolo +
	            ", prezzo_unitario=" + prezzo_unitario + ", descrizione=" + descrizione + "]";
	}
}