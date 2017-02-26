package model;

import java.util.ArrayList;

public class Carrello {

	private ArrayList<ArticoloOrdinato> articoli;
	
	public Carrello() {
		articoli = new ArrayList<ArticoloOrdinato>();
	}

	public void addProdotto(Prodotto prod, int n){
		ArticoloOrdinato art = new ArticoloOrdinato(prod);
		art.setQuantitaOrdinata(n);
		articoli.add(art);
	}
	
	public void setQuantitaOrdinata(Prodotto prod, int n){
		for(int i = 0; i < articoli.size(); i++){
			ArticoloOrdinato artList = articoli.get(i);
			if(prod.getIdProdotto() == artList.getIdProdotto()){
				if(n <= 0){
					articoli.remove(i);
				}
				else	{
					artList.setQuantitaOrdinata(n);
				}
			}
		}
	}
	
	public ArrayList<ArticoloOrdinato> getArticoliOrdinati() {
		return  articoli;
	}
	
	public double getTotale(){
		double tot = 0;
		for(ArticoloOrdinato art : articoli){
			tot += art.getCostoTotale();
		}
		return tot;
	}
	
	public boolean isEmpty(){
		return articoli.isEmpty();
	}
}