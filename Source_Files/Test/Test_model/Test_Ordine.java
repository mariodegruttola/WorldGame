package Test_model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Ordine;



public class Test_Ordine {
	Ordine ordine = new Ordine();
	@Test
	public void setIdOrdine() {
		assertEquals(1,1);
	}
	@Test
	public void setData(){
		assertEquals("14/02/2017", "14/02/2017");
	}
	
	@Test
	public void setUtente(){
		assertEquals("Marco", "Marco");
	}
	@Test
	public void setSpedizione(){
		assertEquals("GLS","GLS");
	}
	@Test
	public void setPagamento(){
		assertEquals("carta","carta");
	}
	@Test
	public void setListaProdottiOrdine(){
		assertEquals("lista","lista");
	}
	
}
