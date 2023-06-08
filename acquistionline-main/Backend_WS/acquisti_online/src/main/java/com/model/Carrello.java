package com.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="carrelli")
public class Carrello {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="cod_cliente")
	private String codCliente;
	
	@Column(name="tipo_pagamento")
	private String tipo_pagamento;
	
	@Column(name="qt_articoli")
	private int qt_articoli;
	
	
	@Column(name="cod_articolo")
	private String codArticolo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCod_cliente() {
		return codCliente;
	}

	public void setCod_cliente(String cod_cliente) {
		this.codCliente = cod_cliente;
	}

	public String getTipo_pagamento() {
		return tipo_pagamento;
	}

	public void setTipo_pagamento(String tipo_pagamento) {
		this.tipo_pagamento = tipo_pagamento;
	}

	public int getQt_articoli() {
		return qt_articoli;
	}

	public void setQt_articoli(int qt_articoli) {
		this.qt_articoli = qt_articoli;
	}

	public String getCod_articolo() {
		return codArticolo;
	}

	public void setCod_articolo(String cod_articolo) {
		this.codArticolo = cod_articolo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codArticolo, codCliente, id, qt_articoli, tipo_pagamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrello other = (Carrello) obj;
		return Objects.equals(codArticolo, other.codArticolo) && Objects.equals(codCliente, other.codCliente)
				&& id == other.id && qt_articoli == other.qt_articoli
				&& Objects.equals(tipo_pagamento, other.tipo_pagamento);
	}

	@Override
	public String toString() {
		return "Carrello [id=" + id + ", cod_cliente=" + codCliente + ", tipo_pagamento=" + tipo_pagamento
				+ ", qt_articoli=" + qt_articoli + ", cod_articolo=" + codArticolo + "]";
	}
	

	
	

}
