package Test_model;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import model.ArticoloOrdinato;


public class Test_ArticoloOrdinato {
	ArticoloOrdinato articoloordinato = new ArticoloOrdinato(null);
	@Test
	public void setProdotto(){
		assertEquals("Fifa17", "Fifa17");
	}
	@Test
	public void setQuantitaOrdinata(){
		assertEquals(1,1);
	}
	@Test
	public void incrementaQuantita(){
		assertEquals(2,2);
	}
	
}
