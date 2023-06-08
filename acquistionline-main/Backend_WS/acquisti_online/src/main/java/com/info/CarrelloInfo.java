package com.info;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class CarrelloInfo {
	
	@JsonInclude(Include.NON_NULL)
	private int id;
	
	@JsonInclude(Include.NON_NULL)
	private String cod_cliente;
	
	@JsonInclude(Include.NON_NULL)
	private String tipo_pagamento;
	
	@JsonInclude(Include.NON_NULL)
	private int qt_articoli;
	
	@JsonInclude(Include.NON_NULL)
	private String cod_articolo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(String cod_cliente) {
		this.cod_cliente = cod_cliente;
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
		return cod_articolo;
	}

	public void setCod_articolo(String cod_articolo) {
		this.cod_articolo = cod_articolo;
	}

}
