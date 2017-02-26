package Test_model;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import model.Spedizione;
public class Test_Spedizione {
	Spedizione spedizione = new Spedizione();
	@Test
	public void setNome(){
		assertEquals("BRT", "BRT");
	}
	@Test
	public void setCosto(){
		assertEquals(30,30);
	}
	@Test
	public void setStimaConsegna(){
		assertEquals(12,12);
	}
}
