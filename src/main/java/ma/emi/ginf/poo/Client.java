package ma.emi.ginf.poo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Client {
	protected int numero;
	protected String adresseFacturation;
	protected String email;
	private Map<Integer,Commande> mesCommandes;
	
	
	public Client(int numero, String adresseFacturation, String email) {
		super();
		this.numero = numero;
		this.adresseFacturation = adresseFacturation;
		this.email = email;
		this.mesCommandes = new HashMap<Integer,Commande>();
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getAdresseFacturation() {
		return adresseFacturation;
	}
	public void setAdresseFacturation(String adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void addCommande(ArrayList<Double> detailCommande) {
		//tout sous hypothese tout les produits sont en stock
		Commande maCommande = new Commande(this);
		mesCommandes.put(maCommande.getNumero(), maCommande);
	}
	public double clalculEncours() {
		double somme = 0;
		for (Commande cmd : mesCommandes.values()) {
			if (!cmd.getIsPaid()) {
				somme = somme + cmd.totalCommandePrice();
			}
		}
		return somme;
	}
}
