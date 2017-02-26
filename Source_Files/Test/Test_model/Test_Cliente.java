package Test_model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Cliente;


public class Test_Cliente {
	Cliente cliente = new Cliente();
	@Test
	public void setCodFisc() {
		assertEquals("ssdfgh78p07a399d","ssdfgh78p07a399d");
	}
	@Test
	public void setPassword() {
		assertEquals("ciao","ciao");
	}
	@Test
	public void setNome() {
		assertEquals("Francesco","Francesco");
	}
	@Test
	public void setCognome() {
		assertEquals("Rossi","Rossi");
	}
	@Test
	public void setEmail() {
		assertEquals("Rossif@gmail.com","Rossif@gmail.com");
	}
	@Test
	public void setIndirizzo() {
		assertEquals("Milano","Milano");
	}
	@Test
	public void setCitta() {
		assertEquals("Milano","Milano");
	}
	@Test
	public void setProvincia() {
		assertEquals("Milano","Milano");
	}
	@Test
	public void setCap() {
		assertEquals("20120","20120");
	}
	@Test
	public void setTelefono() {
		assertEquals("0854502569","0854502569");
	}
	@Test
	public void setNumeroCarta() {
		assertEquals("150258","150258");
	}
	@Test
	public void setScadenzaCarta() {
		assertEquals("25/12/2030","25/12/2030");
	}
	@Test
	public void setPinCarta() {
		assertEquals("124578","124578");
	}
	@Test
	public void setListaOrdini() {
		assertEquals("due","due");
	}
	@Test
	public void aggiungiOrdine() {
		assertEquals("1","1");
	}
	
}
