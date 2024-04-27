package ma.emi.ginf.poo;

import java.time.LocalDate;

public class CommandFinalise implements CommandStatus {
    @Override
    public void traiterCommand(Commande cmd){
        System.out.println("Commande: "+cmd.getNumero() + "Finalisé pretes a livré");
        cmd.facture();
        cmd.setDateLivraison(LocalDate.now());
        System.out.println("enregistré dans la base de données");
    }
}
