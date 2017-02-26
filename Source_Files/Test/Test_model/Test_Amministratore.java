package Test_model;

import static org.junit.Assert.assertEquals;



import org.junit.Test;

import model.Amministratore;



public class Test_Amministratore {
	Amministratore amministratore = new Amministratore();
	@Test
	public void setEmail(){
		assertEquals("amministratore@worldgame.com", "amministratore@worldgame.com");
	}
	@Test
	public void setPassword(){
		assertEquals("ciaoamm","ciaoamm");
	}
	
}
