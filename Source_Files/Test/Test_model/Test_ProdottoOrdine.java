package Test_model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.ProdottoOrdine;

public class Test_ProdottoOrdine {
	ProdottoOrdine prodottoordine = new ProdottoOrdine();
	@Test
	public void setProdotto(){
		assertEquals("Fifa17", "Fifa17");
	}
	@Test
	public void setQuantitaOrdinata(){
		assertEquals(1,1);
	}
	@Test
	public void setPrezzoUnitario(){
		assertEquals(60,60);
	}
	
}
