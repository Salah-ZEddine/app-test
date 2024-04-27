package ma.emi.ginf.poo;

public class DetailCommande {
	private int qte;
	private Produit produit;
	private double prixVenteReel;
	public DetailCommande(int qte, Produit produit, double prixVenteReel) {
		super();
		this.qte = qte;
		this.produit = produit;
		this.prixVenteReel = prixVenteReel;
	}
	public double getPrixVenteReel() {
		return prixVenteReel;
	}

	public int getQte(){
		return qte;
	}
	public Produit getProduit() {
		return produit;
	}
}
