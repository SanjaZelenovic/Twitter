package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	
	private TwitterPoruka tweety;
	private Twitter twitter;
	private LinkedList<TwitterPoruka> plista;
	

	@Before
	public void setUp() throws Exception {
		tweety = new TwitterPoruka();
		twitter = new Twitter();
		plista = new LinkedList<TwitterPoruka>();
	}

	@After
	public void tearDown() throws Exception {
		tweety = null;
		twitter = null;
		plista = null;
	}

	@Test
	public void testVratiSvePorukeNull() {
		
		assertEquals(plista, twitter.vratiSvePoruke());
	}
	
	@Test
	public void testVratiSvePorukeJedna() {
		
		tweety.setKorisnik("Sanja");
		tweety.setPoruka("poruka neka");
		
		twitter.unesi(tweety.getKorisnik(), tweety.getPoruka());
		
		plista.addLast(tweety);
		
		assertEquals(1, twitter.vratiSvePoruke().size());
		assertEquals(tweety, twitter.vratiSvePoruke().get(0));
	}
	
	@Test
	public void testVratiSvePorukeDve() {
		
		tweety.setKorisnik("Sanja");
		tweety.setPoruka("poruka neka");
		
		TwitterPoruka tweety2 = new TwitterPoruka();
		
		tweety2.setKorisnik("Sanja");
		tweety2.setPoruka("poruka neka");
		
		twitter.unesi(tweety.getKorisnik(), tweety.getPoruka());
		twitter.unesi(tweety2.getKorisnik(), tweety2.getPoruka());
		
		plista.addLast(tweety);
		plista.addLast(tweety2);
		
		assertEquals(2, twitter.vratiSvePoruke().size());
		assertEquals(plista, twitter.vratiSvePoruke());
	}

	@Test
	public void testUnesiJednuPoruku() {
		
		tweety.setKorisnik("Sanja");
		tweety.setPoruka("poruka neka");
		
		twitter.unesi(tweety.getKorisnik(), tweety.getPoruka());
		
		plista.addLast(tweety);
		assertEquals(1, twitter.vratiSvePoruke().size());
		assertEquals(tweety, twitter.vratiSvePoruke().get(0));
		
		// U klasi Twitter u metodi unesi uocena je greska, umesto da je postavljen korisnik koji je unet kao parametar unet je String "korisnik"
	}
	
	@Test
	public void testUnesiDva() {
		
		tweety.setKorisnik("Sanja");
		tweety.setPoruka("poruka neka");
		
		TwitterPoruka tweety2 = new TwitterPoruka();
		
		tweety2.setKorisnik("Sanja");
		tweety2.setPoruka("poruka neka druga");
		
		twitter.unesi(tweety.getKorisnik(), tweety.getPoruka());
		twitter.unesi(tweety2.getKorisnik(), tweety2.getPoruka());
		
		plista.addLast(tweety);
		plista.addLast(tweety2);
		
		assertEquals(2, twitter.vratiSvePoruke().size());
		assertEquals(plista, twitter.vratiSvePoruke());
		
	}
	
	@Test
	public void testVratiPoruke() {
		
		tweety.setKorisnik("Sanja");
		tweety.setPoruka("poruka neka");
		
		TwitterPoruka tweety2 = new TwitterPoruka();
		
		tweety2.setKorisnik("Sanja");
		tweety2.setPoruka("poruka druga");
		
		TwitterPoruka [] nizporuka = new TwitterPoruka [2];
		nizporuka[0]= tweety;
		nizporuka[1]= tweety2;
		
		twitter.unesi(tweety.getKorisnik(), tweety.getPoruka());
		twitter.unesi(tweety2.getKorisnik(), tweety2.getPoruka());
		
		assertArrayEquals(nizporuka, twitter.vratiPoruke(2, "poruka"));
		
		//Greska u metodi je u tome sto kada prolazi kroz listu pomocu
		//for petlje i kada naidje na prvi twitt sa zadatim tagom, on ga 
		//postavlja na mesto 1 umesto na nultu poziciju, zbog [brojac+1].
		//To znaci da automatski gubimo jedno mesto.
	}
	
	@Test ( expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNullTag() {
		
		twitter.vratiPoruke(26, null);
	}

	@Test ( expected = java.lang.RuntimeException.class)
	public void testVratiPorukePazanTag() {
		
		twitter.vratiPoruke(26, "");
	}
	
	@Test 
	public void testVratiPorukeNegativan() {
		
		twitter.vratiPoruke(-26, "neki");
	}
	
}
