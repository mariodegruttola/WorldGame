package model;

public class ProdottoOrdine {
	
	private Prodotto prodotto;
	private int quantitaOrdinata;
	private double prezzoUnitario;

	public ProdottoOrdine(Prodotto prodotto, int quantita, double prezzo){
		this.prodotto = prodotto;
		quantitaOrdinata = quantita;
		prezzoUnitario = prezzo;
	}
	
	public ProdottoOrdine(){
		prodotto = null;
		quantitaOrdinata = 0;
		prezzoUnitario = 0;
	}
	
	public Prodotto getProdotto(){
		return prodotto;
	}
	
	public int getQuantitaOrdinata(){
		return quantitaOrdinata;
	}

	public double getPrezzoUnitario(){
		return prezzoUnitario;
	}
	
	public void setProdotto(Prodotto prod){
		prodotto = prod;
	}
	
	public void setQuantitaOrdinata(int quantita){
		quantitaOrdinata = quantita;
	}
	
	public void setPrezzoUnitario(double prezzo){
		prezzoUnitario = prezzo;
	}
	
	public double getCostoTotale(){
		return quantitaOrdinata * prezzoUnitario;
	}
}