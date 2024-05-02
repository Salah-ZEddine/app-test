package ma.emi.ginf.poo;

import java.time.LocalDate;
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
	public void addCommande(ArrayList<DetailCommande> detailCommande) {
		Commande maCommande = new Commande(this);
		for(DetailCommande d : detailCommande) {
			maCommande.ajouterCommande(d);
		}
		this.mesCommandes.put(maCommande.getNumero(), maCommande);
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
	public void afficheHistorique(LocalDate debut, LocalDate fin) {
		for (Commande cmd : mesCommandes.values()) {
			if(cmd.getDateCommande().isAfter(debut) && cmd.getDateCommande().isBefore(fin)){
				System.out.println(cmd);
			}
		}
	}
}
