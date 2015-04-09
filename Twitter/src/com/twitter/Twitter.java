package com.twitter;
	
import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;
	
/**
 *Naziv klase: Twitter
 * Sadrzi metodu za vracanje svih poruka, metodu za unos nove poruke i metodu za vracanje poruka sa naznacenim tagom.
 * 
 * @author Sanja
 *
 */
public class Twitter {
		
	/**
	 * Atribut koji predstavlja listu svih poruka.
	 * 
	 * Lista je odmah inicijalizovana.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
		
	/**
	 * Metoda: vraca sve poruke iz liste poruke.
	 * 
	 * @return sve poruke iz liste poruke.
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	
	/**
	 * Metoda postavlja vrednost atributa korisnik i poruka na prosledjene parametre i u listu unosi novu poruku za tog korisnika.
	 * 
	 * @param korisnik twitter naloga
	 * @param poruka koju korisnik namerava da twittuje
	 */
	public void unesi(String korisnik, String poruka) {
		
		//Pravi se nova poruka i puni podacima.
		
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
		}
	
	/**
	 * Metoda vraca sve poruke koje sadrze zadati tag, koji je unet kao parametar, pri cemu je broj poruka koje ce biti 
	 * vracene jednak zadatom broju, koji je takodje prosledjen u vidu parametra maxBroj.
	 *
	 * @param maxBroj predstavlja maksimalan broj poruka sa tim tagom koje je moguce prikazati
	 * @param tag predstavlja vrednost na osnovu koje vrsimo pretragu twittova, odnosno trazimo sve poruke koje u sebi sadrze taj tag.
	 * @return niz svih poruka sa tim tagom, pri cemu je kapacitet tog niza jednak maxBroj
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) throws RuntimeException {
        
		if (tag==null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		
        //Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		
        if (maxBroj<=0)
			maxBroj = 100;
		
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		
		int brojac = 0;
		
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					rezultat[brojac]=poruke.get(i);
					brojac++;
				}
				
				else break;
			return rezultat;
		}
	} 
