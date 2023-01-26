package logic.observer;
import javafx.fxml.FXML;
import logic.SceneController;
import logic.factory.BaseObject;

import javax.swing.*;

public class TaskObserver implements Observer {
    BaseObject tsk;

    public TaskObserver(BaseObject tsk){
        this.tsk = tsk;
    }

    @Override
    public void update() {
        JOptionPane.showMessageDialog(null,"Complimenti hai completato la Task: " + tsk.getName() + "\n\nControlla nel profilo e vedrai che la tua esperienza è aumentata di " + tsk.getReward() + "!" ,"MESSAGGIO DA MOTEEVE",JOptionPane.INFORMATION_MESSAGE);
    }
}
