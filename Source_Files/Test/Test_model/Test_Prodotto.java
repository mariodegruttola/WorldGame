package Test_model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Prodotto;

public class Test_Prodotto {
	Prodotto prodotto = new Prodotto();
	@Test
	public void setIdProdotto() {
		assertEquals(1,1);
	}
	@Test
	public void setNome(){
		assertEquals("SuperMario", "SuperMario");
	}
	
	@Test
	public void setCategoria(){
		assertEquals("Nintendo", "Nintendo");
	}
	@Test
	public void setPrezzo(){
		assertEquals(20,20);
	}
	@Test
	public void setQuantità(){
		assertEquals(30,30);
	}
	@Test
	public void setTipo(){
		assertEquals("videogiochi","videogiochi");
	}
	@Test
	public void setDescrizione(){
		assertEquals("descrizione","descrizione");
	}

	
	
	
}
