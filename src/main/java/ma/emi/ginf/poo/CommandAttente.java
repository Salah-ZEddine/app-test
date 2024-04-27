package ma.emi.ginf.poo;


public class CommandAttente implements CommandStatus{
    @Override
    public void traiterCommand(Commande cmd){
        for(DetailCommande d: cmd.getDts()){
            if(d.getQte()>d.getProduit().getStock()){
                System.out.println("envoyer demande approvosionnement du stock du produit : "+d.getProduit());
            }
        }
    }
}
