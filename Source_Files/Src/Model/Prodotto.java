package model;

import java.io.Serializable;

public class Prodotto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	double prezzo;
	int idProdotto, quantita;
	String nome, categoria, tipo, descrizione;
	
	public Prodotto() {
		idProdotto = -1;
		nome = "";
		categoria = "";
		quantita = 0;
		tipo = "";
		prezzo = 0; 
		descrizione = "";
	}

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescrizione(){
		return descrizione;
	}
	public void setDescrizione(String desc){
		descrizione = desc;
	}
	@Override
	public String toString() {
		return nome + " (" + idProdotto + "), " + prezzo + " " + quantita + ". " + categoria + ", " + tipo;
	}

}
