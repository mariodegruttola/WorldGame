package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String email , password, codFisc, nome, cognome, indirizzo, citta, provincia, cap, telefono, numeroCarta, scadenzaCarta, pinCarta;
	private List<Ordine> listaOrdini;
	
	public Cliente(){
		password = "";
		codFisc = "";
		nome = "";
		cognome = "";
		email = "";
		indirizzo = "";
		citta = "";
		provincia = "";
		cap = "";
		telefono = "";
		numeroCarta = "";
		scadenzaCarta = "";
		pinCarta= "";
		listaOrdini = new ArrayList<Ordine>();
	}
	public String getPassword(){
		return password;
	}
	public String getCodFisc(){
		return codFisc;
	}
	public String getNome(){
		return nome;
	}
	public String getCognome(){
		return cognome;
	}
	public String getEmail(){
		return email;
	}
	public String getIndirizzo(){
		return indirizzo;
	}
	public String getCitta(){
		return citta;
	}
	public String getProvincia(){
		return provincia;
	}
	public String getCap(){
		return cap;
	}
	public String getTelefono(){
		return telefono;
	}
	public String getNumeroCarta(){
		return numeroCarta;
	}
	public String getScadenzaCarta(){
		return scadenzaCarta;
	}
	public String getPinCarta(){
		return pinCarta;
	}
	public List<Ordine> getListaOrdini() {
		return listaOrdini;
	}
	public void setCodFisc(String cod){
		codFisc = cod;
	}
	public void setPassword(String pass){
		password = pass;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setCognome(String cogn){
		cognome = cogn;
	}
	public void setEmail(String em){
		email = em;
	}
	public void setIndirizzo(String ind){
		indirizzo = ind;
	}
	public void setCitta(String cit){
		citta = cit;
	}
	public void setProvincia(String prov){
		provincia = prov;
	}
	public void setCap(String c){
		cap = c;
	}
	public void setTelefono(String tel){
		telefono = tel;
	}
	public void setNumeroCarta(String num){
		numeroCarta = num;
	}
	public void setScadenzaCarta(String scad){
		scadenzaCarta = scad;
	}
	public void setPinCarta(String pin){
		pinCarta = pin;
	}
	public void setListaOrdini(ArrayList<Ordine> listaOrdini) {
		this.listaOrdini = listaOrdini;
	}
	public void aggiungiOrdine(Ordine ordine) {
		listaOrdini.add(ordine);
	}
	public String toString(){
		return "Email: " + email + " - Password:" + password;
	}
}