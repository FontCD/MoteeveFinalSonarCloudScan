package logic.observer;


import logic.Main;
import logic.factory.BaseObject;

import javax.swing.*;

public class AchievementObserver implements Observer {

    BaseObject ach;

    public AchievementObserver(BaseObject ach) {
        this.ach = ach;
    }

    @Override
    public void update() {
        if (Main.VIEW.equals("CLI")){
            System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\nMESSAGE:\nCompliementi hai completato l'Achivevement " + ach.getName() + ", controlla nel profilo e vedrai di aver sbloccato un nuovo Sticker!\n//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        } else if(Main.VIEW.equals("FX")){
            JOptionPane.showMessageDialog(null,"Complimenti hai completato l'Achievement: " + ach.getName() + "\n\nControlla nel profilo e vedrai un nuovo Sticker!" ,"MESSAGGIO DA MOTEEVE",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

