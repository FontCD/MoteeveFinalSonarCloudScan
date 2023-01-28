package logic.observer;

import logic.Main;
import logic.factory.BaseObject;

import javax.swing.*;

//OBSERVER RELATIVO ALLE TASK
public class TaskObserver implements Observer {
    BaseObject tsk;

    public TaskObserver(BaseObject tsk){
        this.tsk = tsk;
    }

    //METODI OBSERVER
    @Override
    public void update() {
        if(Main.view.equals("CLI")){
            System.out.println("\n\n//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////\nMESSAGE:\nCompliementi hai completato un la Task " + this.tsk.getName() + ", ora la tua esperienza è aumentata di " + this.tsk.getReward() + "\n//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        } else if(Main.view.equals("FX")){
            JOptionPane.showMessageDialog(null,"Complimenti hai completato la Task: " + tsk.getName() + "\n\nControlla nel profilo e vedrai che la tua esperienza è aumentata di " + tsk.getReward() + "!" ,"MESSAGGIO DA MOTEEVE",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
