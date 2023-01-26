package logic.observer;


import logic.factory.BaseObject;

import javax.swing.*;

public class AchievementObserver implements Observer {

    BaseObject ach;

    public AchievementObserver(BaseObject ach) {
        this.ach = ach;
    }

    @Override
    public void update() {
        JOptionPane.showMessageDialog(null,"Complimenti hai completato l'Achievement: " + ach.getName() + "\n\nControlla nel profilo e vedrai un nuovo Sticker!" ,"MESSAGGIO DA MOTEEVE",JOptionPane.INFORMATION_MESSAGE);
    }
}

