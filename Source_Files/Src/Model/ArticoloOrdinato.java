package model;

public class ArticoloOrdinato {
	private Prodotto prodotto;
	private int quantitaOrdinata;

	public ArticoloOrdinato(Prodotto prodotto){
		this.prodotto = prodotto;
		quantitaOrdinata = 1;
	}
	
	public Prodotto getProdotto(){
		return prodotto;
	}
	
	public int getQuantitaOrdinata(){
		return quantitaOrdinata;
	}
	
	public void setQuantitaOrdinata(int quantita){
		quantitaOrdinata = quantita;
	}
	public void incrementaQuantita(){
		quantitaOrdinata = quantitaOrdinata + 1;
	}
	public double getCostoTotale(){
		return quantitaOrdinata * getPrezzo();
	}
	
	//Metodi get di prodotto
	public int getIdProdotto() {
		return prodotto.getIdProdotto();
	}

	public String getNome() {
		return prodotto.getNome();
	}

	public String getCategoria() {
		return prodotto.getCategoria();
	}

	public double getPrezzo() {
		return prodotto.getPrezzo();
	}

	public int getQuantitaMax() {
		return prodotto.getQuantita();
	}
	
	public String getTipo() {
		return prodotto.getTipo();
	}

	public String getDescrizione(){
		return prodotto.getDescrizione();
	}

}
