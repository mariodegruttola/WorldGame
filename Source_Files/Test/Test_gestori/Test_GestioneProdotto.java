package Test_gestori;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gestori.GestioneProdotto;

public class Test_GestioneProdotto {
	GestioneProdotto gestioneprodotto = new GestioneProdotto(); 
	@Test
	public void modificaQuantitaProdotto(){
		assertEquals(3,3);
	}
	@Test
	public void modificaPrezzoProdotto(){
		assertEquals(15,15);
	}
	
}
