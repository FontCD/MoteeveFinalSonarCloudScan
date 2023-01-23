package logic.model;

import logic.dao.TaskDAOJDBC;
import logic.factory.BaseObject;
import logic.observer.Observer;
import logic.observer.Subject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task implements BaseObject, Subject {

    private List<Observer> observers = new ArrayList<>();
    private int id;
    private String name;
    private String script;
    private String color ;
    private boolean status;
    private int reward ;


    public Task (int id, String name, String script, String color,boolean status, int reward) { 	//costruttore completo
        this.id = id;
        this.name = name ;
        this.script = script ;
        this.color = color ;
        this.status = status ;
        this.reward = reward ;

    }
    @Override
    public void setObject(int id, String name, String script, String color,boolean status, int reward) {
        this.id = id;
        this.name = name ;
        this.script = script ;
        this.color = color ;
        this.status = status ;
        this.reward = reward ;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getScript() {
        return script;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public int getReward() {
        return reward ;
    }

    @Override
    public void setComplete() {
        this.status = true;

        notifyObservers();
    }

    @Override
    public void setCompletable() {
        this.status = true;
    }

    //da eliminare (nessun effetto collatelare)
    @Override
    public void setBaseObjectById(int index) throws Exception {
        TaskDAOJDBC dao = new TaskDAOJDBC() ;

        this.id = dao.extractIdCurrent(index) ;
        if (this.id != 9999){
            this.name = dao.extractNameCurrent(index);
            this.script = dao.extractScriptCurrent(index);
            this.color = dao.extractColorCurrent(index);
            this.status = dao.extractStatusCurrent(index);
            this.reward = dao.extractRewardCurrent(index);
        } else {
            this.name = null;
            this.script = null;
            this.color = null;
            this.status = false;
            this.reward = 0;
        }

    }


    @Override
    public void attach(Observer obs) {
        this.observers.add(obs) ;
    }

    @Override
    public void detach(Observer obs) {
        this.observers.remove(obs) ;
    }

    @Override
    public void notifyObservers() {
        Iterator<Observer> i = observers.iterator();
        while (i.hasNext()) {
            Observer obs = i.next();
            obs.update();
        }
    }
}
