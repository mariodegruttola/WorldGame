package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Ordine {
	private String data, cliente, pagamento;
	private int idOrdine;
	private Spedizione spedizione;
	private List<ProdottoOrdine> listaProdottiOrdine;
	
	public Ordine(){
		idOrdine = 0;
		data = "";
		cliente = "";
		spedizione = new Spedizione();
		pagamento = "";
		listaProdottiOrdine = new ArrayList<ProdottoOrdine>();
	}
	public int getIdOrdine(){
		return idOrdine;
	}
	public String getData(){
		return data;
	}
	public String getCliente(){
		return cliente;
	}
	public Spedizione getSpedizione(){
		return spedizione;
	}
	public String getPagamento(){
		return pagamento;
	}
	public List<ProdottoOrdine> getListaProdottiOrdine() {
		return listaProdottiOrdine;
	}
	public String getDataConsegna() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dd = "";
		try {
			Date date = formatter.parse(data);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, spedizione.getStimaConsegna());
			date = calendar.getTime();
			dd = formatter.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dd;
	}
	public void setIdOrdine(int ordine){
		idOrdine = ordine;
	}
	public void setData(String data){
		this.data = data;
	}
	public void setUtente(String cliente){
		this.cliente = cliente;
	}
	public void setSpedizione(Spedizione spedizione){
		this.spedizione = spedizione;
	}
	public void setPagamento(String pagamento){
		this.pagamento = pagamento;
	}
	public void setListaProdottiOrdine(ArrayList<ProdottoOrdine> lista) {
		listaProdottiOrdine = lista;
	}
}
