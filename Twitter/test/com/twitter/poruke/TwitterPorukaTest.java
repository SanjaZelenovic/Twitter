package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwitterPorukaTest {

	TwitterPoruka tweety;
	
	@Before
	public void setUp() throws Exception {
	tweety = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		tweety = null;
	}

	@Test
	public void testSetKorisnik() {
		tweety.setKorisnik("Tweety");
		
		assertEquals("Tweety", tweety.getKorisnik());
	}
	
	@Test ( expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tweety.setKorisnik(null);
		
	}
	
	@Test ( expected = java.lang.RuntimeException.class)
	public void testSetKorisnikEmpty() {
		tweety.setKorisnik("");
		
	}
	

	@Test
	public void testSetPoruka() {
		tweety.setPoruka("Da li ste spremni deco? - Jesmo kapetane!");
		
		assertEquals("Da li ste spremni deco? - Jesmo kapetane!", tweety.getPoruka());
	}
	
	@Test ( expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tweety.setPoruka(null);
	}
	
	@Test ( expected = java.lang.RuntimeException.class)
	public void testSetPorukaLength() {
		tweety.setPoruka("blablalblbalabalbalablblablblbalabablaba"
				+ "lbalabalblblbaalblablaablabalablabalblblabalbala"
				+ "baalbalablaabalabalabalbalbalbalablabalbalabaalab"
				+ "laablabalaablabalaablabalabalaablablablabalbalabal");
	}
	

	@Test
	public void testToString() {
	
		tweety.setKorisnik("Sanja");
		tweety.setPoruka("Stigla je poruka.");
		
		assertEquals("KORISNIK:"+"Sanja"+" PORUKA:"+"Stigla je poruka.", tweety.toString());
	}

}
