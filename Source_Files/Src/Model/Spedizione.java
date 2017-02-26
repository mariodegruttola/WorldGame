package model;

public class Spedizione {
	String nome;
	int costi, stimaConsegna;
	public Spedizione(){
		nome = "";
		costi = 0;
		stimaConsegna = 0;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public void setCosto(int costi){
		this.costi = costi;
	}
	public void setStimaConsegna(int stima){
		stimaConsegna = stima;
	}
	public String getNome(){
		return nome;
	}
	public int getCosti(){
		return costi;
	}
	public int getStimaConsegna(){
		return stimaConsegna;
	}
}
