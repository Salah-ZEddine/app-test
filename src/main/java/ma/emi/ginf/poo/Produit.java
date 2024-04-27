package ma.emi.ginf.poo;

public class Produit {
  private int code;
  private String libelle;
  private double prixHt;
  private int stock;
  public int getStock(){
    return stock;
  }
  public void setStock(int stock){
    this.stock = stock;
  }
}
