package gestori;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import connessioniDataBase.ConnProdottoOrdine;
import connessioniDataBase.ConnOrdine;
import connessioniDataBase.ConnProdotto;
import connessioniDataBase.ConnSpedizione;
import model.ArticoloOrdinato;
import model.Carrello;
import model.Cliente;
import model.Ordine;
import model.Prodotto;
import model.ProdottoOrdine;
import model.Spedizione;

public class GestioneAcquisto {

	public Prodotto infoProdotto(int idProdotto) throws SQLException {
		
		ConnProdotto cn = new ConnProdotto();
		return cn.doRetrieveByKey(idProdotto);
	}
	
	public ArrayList<Prodotto> ricercaProdottoChiave(String chiave, String ordine) throws SQLException{
		
		ConnProdotto cn = new ConnProdotto();
		Collection<Prodotto> listaP = cn.doRetrieveAll(ordine);
		
		String in = "";
		String fi = "";
		if(chiave.length() > 4){
			in = chiave.substring(0, chiave.length()/2);
			fi = chiave.substring(chiave.length()/2, chiave.length());
		}
		else{
			in = chiave;
			fi = chiave;
		}
		
		ArrayList<Prodotto> listaScelta = new ArrayList<Prodotto>();
		if (listaP != null && listaP.size() != 0) {
			Iterator<?> it = listaP.iterator();
			while (it.hasNext()) {
				Prodotto prod = (Prodotto) it.next();
				if(prod.getNome().equalsIgnoreCase(chiave) || prod.getNome().toLowerCase().contains(chiave.toLowerCase()) || prod.getNome().toLowerCase().contains(in.toLowerCase()) || prod.getNome().toLowerCase().contains(fi.toLowerCase())){
					listaScelta.add(prod);
					it.remove();
				}
			}
		}
		return listaScelta;
	}

	public ArrayList<Prodotto> ricercaProdotto(String categoria, String tipo, String ordine) throws SQLException {
		
		ConnProdotto cn = new ConnProdotto();
		ArrayList<Prodotto> listaProd = null;
		if(!tipo.equals("null")){
			listaProd = cn.doRetrieveByCatAndTipo(categoria, tipo, ordine);
		}
		else {
			listaProd = cn.doRetrieveByCat(categoria, ordine);
		}
		return listaProd;
	}
	
	public List<Spedizione> getListaSpedizioni() throws SQLException{
		
		ConnSpedizione cn = new ConnSpedizione();
		return cn.doRetrieveAll();
	}

	public Cliente acquista(Spedizione spedizione, Cliente cliente, Carrello carrello) {
		
		ConnOrdine cnOrdine = new ConnOrdine();
		ConnProdotto cnProdotto = new ConnProdotto();
		ConnProdottoOrdine cnFormatoDa = new ConnProdottoOrdine();
		// ricavo data in per il formato di mysql
		Date unDate = new Date(); //ad esempio
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String data = formato.format(unDate);
		
		Ordine ordine = new Ordine();
		ordine.setData(data);
		ordine.setUtente(cliente.getEmail());
		ordine.setSpedizione(spedizione);
		ordine.setPagamento(cliente.getNumeroCarta());
		
		int id = 0;
		try {
			id = cnOrdine.doSave(ordine);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ordine.setIdOrdine(id);
		
		ArrayList<ProdottoOrdine> listaProdottiOrdine = new ArrayList<ProdottoOrdine>();
		ArrayList<ArticoloOrdinato> lista = carrello.getArticoliOrdinati();
		for(ArticoloOrdinato art : lista){			
			Prodotto pr = art.getProdotto();
			pr.setQuantita((pr.getQuantita() - art.getQuantitaOrdinata()));
			
			ProdottoOrdine prodOrd = new ProdottoOrdine();
			prodOrd.setProdotto(pr);
			prodOrd.setPrezzoUnitario(pr.getPrezzo());
			prodOrd.setQuantitaOrdinata(art.getQuantitaOrdinata());
			listaProdottiOrdine.add(prodOrd);
			
			try {
				cnProdotto.doUpdateQuantita(pr);
				cnFormatoDa.doSave(id, art.getIdProdotto(), art.getQuantitaOrdinata(), art.getPrezzo());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		ordine.setListaProdottiOrdine(listaProdottiOrdine);
		cliente.aggiungiOrdine(ordine);
		return cliente;
	}

	public List<Prodotto> getListaProdHome() throws SQLException {
		ConnProdotto cnProdotto = new ConnProdotto();
		return cnProdotto.doRetrieveForHome();
	}
}