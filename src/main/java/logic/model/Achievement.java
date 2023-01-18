package logic.model;

import logic.dao.AchievementDAOJDBC;
import logic.factory.BaseObject;
import logic.observer.Observer;
import logic.observer.Subject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Achievement implements BaseObject, Subject {																			//Entity

    private List<Observer> observers = new ArrayList<>();
    private int id;
    private String name;
    private String script;
    private String color ;
    private boolean status;
    private int reward ;


    public Achievement(int id, String name, String script, String color, boolean status, int reward) { 					//costruttore completo
        this.id = id ;
        this.name = name ;
        this.script = script ;
        this.color = color ;
        this.status = status ;
        this.reward = reward ;
    }

    @Override
    public void setObject(int id, String name, String script, String color, boolean status, int reward) {
        this.id = id;
        this.name = name ;
        this.script = script ;
        this.color = color ;
        this.status = status ;
        this.reward = reward ;
    }

    @Override
    public int getId() {
        return id ;
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

    //da eliminare, è un safe delete
    @Override
    public void setBaseObjectById(int index) throws Exception {
        AchievementDAOJDBC dao = new AchievementDAOJDBC() ;

        this.id = index ;
        this.name = dao.extractName(index);
        this.script = dao.extractScript(index);
        this.color = dao.extractColor(index);
        this.status = dao.extractStatus(index);
        this.reward = dao.extractReward(index);
    }

    @Override
    public void setComplete() {
        this.script = "Completato";
        notifyObservers();
    }
    @Override
    public void setCompletable() {
        this.status = true;
        notifyObservers();
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
