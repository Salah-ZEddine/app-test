package ma.emi.ginf.domain;

public class CommandInit implements CommandStatus {
    @Override
    public void traiterCommand(Commande cmd){
        System.out.println("CommandInitialiseee ......");
    }
}
