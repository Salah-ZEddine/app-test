package ma.emi.ginf.poo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ma.emi.ginf.poo.helper.KeyGenerator;

public class Commande {
	private int numero;
	private LocalDate dateCommande;
	private Client owner;
	private List<DetailCommande> dts ;
	private Boolean isPaid;
	private LocalDate dateLivraison;
	private CommandStatus status = new CommandInit();
	
	public Commande(Client client) {
		this.numero = KeyGenerator.getKey();
		this.dateCommande = LocalDate.now();
		this.owner= client;
		this.dts = new ArrayList<DetailCommande>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public LocalDate getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(LocalDate dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}

	public Boolean getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(Boolean paid) {
		isPaid = paid;
	}

	public List<DetailCommande> getDts() {
		return dts;
	}
	public double totalCommandePrice(){
		double total = 0;
		for(DetailCommande d : dts)
			total = total + d.getPrixVenteReel();
		return total;
	}
	public void facture(){
		System.out.println("..........Bon de facture..............");
		for(DetailCommande d : dts){
			System.out.println(d);
		}
		System.out.println("prix est : " + totalCommandePrice());
		System.out.println("..........Bon de facture..............");
	}

	public LocalDate getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(LocalDate dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public void ajouterCommande(DetailCommande details){
		if(details.getQte()>details.getProduit().getStock()){
			System.out.println("rupture de stock pour la commande "+ this.getNumero());
			status = new CommandInit();
		}
		this.dts.add(details);
		details.getProduit().setStock(details.getProduit().getStock()-details.getQte());
		System.out.println("Produit ajoutee!");
	}
	@Override
	public String toString(){
		String paid = "payee";
		if(!getIsPaid()){
			paid = "n/'est pas payee";
			return "La commande de numero : "+ this.numero + "de date : " + this.dateCommande +"est "+ paid;
		}
		return "La commande de numero : "+ this.numero + "de date : " + this.dateCommande +"est "+ paid+
				"et livree le : "+ this.dateLivraison;
	}
}
