package com.twitter.poruke;

/**
 * Naziv klase: TwitterPoruka
 * Sadrzi set i get metode za sve atribute, kao i toString() metodu.
 * 
 * @author Sanja
 * 
 */
public class TwitterPoruka {

	/**
	 * Atribut: korisnik - identifikuje osobu koja postavlja poruke(twittove) na twitter.
	 */
	private String korisnik;
	
	/**
	 * Atribut: poruka - sadrzaj twitta, koji odgovarajuci korisnik postavlja na twitter.
	 */
	private String poruka;
	
	/**
	 * Metoda: getKorisnik() - vraca ime korisnika twittera
	 * @return ime korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Metoda: postavlja ime korisnika na vrednost koju dobija kao parametar
	 * 
	 * Metoda ima logicku kontrolu:
	 * 		<ul>
	 * 			<li> prosledjeni parametar ne sme imati vrednost null
	 * 			<li> prosledjeni parametar ne sme biti prazan String
	 * 		</ul>
	 * 
	 * @param korisnik
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik.equals(""))
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * Metoda: vraca String sa sadrzajem poruke koja je postavljena na twitter
	 * 
	 * @return sadrzaj poruke
	 */
	public String getPoruka() {
		return poruka;
	}
	
	/**
	 * Metoda: posatavlja poruku na vrednost koja je metodi proslednjena kao parametar
	 * 
	 * Metoda ima logicku kontrolu:
	 *  	<ul>
	 * 			<li> prosledjeni parametar ne sme imati vrednost null
	 * 			<li> duzina prosledjenog Stringa (parametra) ne sme biti duza od 140 karatktera
	 * 		</ul>
	 * 
	 * @param poruka
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || poruka.length()>140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	/**
	 * Metoda vraca sve parametre u vidu Stringa
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}
}
