package logic.observer;


import logic.Main;
import logic.factory.BaseObject;

import javax.swing.*;

//OBSERVER RELATIVO AGLI ACHIEVEMENTS
public class AchievementObserver implements Observer {

    //ATTRIBUTI
    BaseObject ach;

    public AchievementObserver(BaseObject ach) {
        this.ach = ach;
    }

    //METODO OBSERVER
    @Override
    public void update() {
        if (Main.view.equals("CLI")){
            System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\nMESSAGE:\nCompliementi hai completato l'Achivevement " + ach.getName() + ", controlla nel profilo e vedrai di aver sbloccato un nuovo Sticker!\n//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        } else if(Main.view.equals("FX")){
            JOptionPane.showMessageDialog(null,"Complimenti hai completato l'Achievement: " + ach.getName() + "\n\nControlla nel profilo e vedrai un nuovo Sticker!" ,"MESSAGGIO DA MOTEEVE",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

