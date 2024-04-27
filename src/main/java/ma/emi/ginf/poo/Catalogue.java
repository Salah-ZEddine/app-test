package ma.emi.ginf.poo;

import java.util.List;

public class Catalogue {
    private List<Produit> catalogue;
    public Catalogue(List<Produit> catalogue) {
        this.catalogue = catalogue;
    }

    public List<Produit> getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(List<Produit> catalogue) {
        this.catalogue = catalogue;
    }
    public void afficheCatalogue(List<Produit> catalogue) {
        for(Produit p : catalogue) {
            System.out.println(p);
        }
    }
}
