package logic.observer;

import logic.factory.BaseObject;

public class AchievementObserver implements Observer {

    BaseObject ach;

    public AchievementObserver(BaseObject ach) {
        this.ach = ach;
    }

    @Override
    public void update() {
        if (ach.getStatus() && ach.getScript().equals("Completato")) {
            System.out.println("Compliementi hai completato l'Achivevement " + ach.getName() + ", controlla negli sticker e vedrai di aver scbloccato lo Sticker " + this.ach.getReward());
        } else if(ach.getStatus()){
            System.out.println("Ehi, l'Achievevemt: " + this.ach.getName() + " è ora dipsonibile per essere sbloccato");
        }
    }
}

