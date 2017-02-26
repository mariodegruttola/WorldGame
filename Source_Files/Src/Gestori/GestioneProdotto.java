package gestori;

import java.sql.SQLException;
import java.util.Collection;

import connessioniDataBase.ConnProdotto;
import model.Prodotto;

public class GestioneProdotto {
	
	public void inserisciProdotto(String nome, Double prezzo, int quantita, String categoria, String tipo, String descrizione) throws SQLException {
		
		ConnProdotto cn = new ConnProdotto();
		Prodotto prod = new Prodotto();
		
		prod.setNome(nome);
		prod.setPrezzo(prezzo);
		prod.setQuantita(quantita);
		prod.setCategoria(categoria);
		prod.setTipo(tipo);
		prod.setDescrizione(descrizione);
		
		cn.doSave(prod);
	}
	
	public void modificaPrezzoProdotto(Prodotto temp) throws SQLException {
		
		ConnProdotto cn = new ConnProdotto();
		cn.doUpdatePrezzo(temp);
	}
	
	public void modificaQuantitaProdotto(Prodotto temp) throws SQLException {
		
		ConnProdotto cn = new ConnProdotto();
		cn.doUpdateQuantita(temp);
	}
	
	public Collection<Prodotto> getListaProdotti() throws SQLException {
		
		ConnProdotto cn = new ConnProdotto();
		return  cn.doRetrieveAll(null);
	}
}
