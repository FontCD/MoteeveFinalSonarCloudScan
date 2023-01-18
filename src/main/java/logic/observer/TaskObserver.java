package logic.observer;

import logic.factory.BaseObject;

public class TaskObserver implements Observer {
    BaseObject tsk;

    public TaskObserver(BaseObject tsk){
        this.tsk = tsk;
    }

    @Override
    public void update() {
        System.out.println("Compliementi hai completato un la Task " + this.tsk.getName() + ", ora la tua esperienza è aumentata di " + this.tsk.getReward());
    }
}
