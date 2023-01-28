package logic.model;

import logic.factory.BaseObject;
import logic.observer.Observer;
import logic.observer.Subject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//ENTITY ACHIEVEMENT
public class Achievement implements BaseObject, Subject {

    //ATTRIBUTI
    private List<Observer> achObservers = new ArrayList<>();
    private int achId;
    private String achName;
    private String achScript;
    private String achColor ;
    private boolean achStatus;
    private int achReward ;

    //COSTRUTTORE COMPLETO
    public Achievement(int id, String name, String script, String color, boolean status, int reward) {
        this.achId = id ;
        this.achName = name ;
        this.achScript = script ;
        this.achColor = color ;
        this.achStatus = status ;
        this.achReward = reward ;
    }

    //METODI ENTITY
    @Override
    public int getId() {
        return this.achId;
    }

    @Override
    public String getName() {
        return this.achName;
    }

    @Override
    public String getScript() {
        return this.achScript;
    }

    @Override
    public String getColor() {
        return this.achColor;
    }

    @Override
    public boolean getStatus() {
        return this.achStatus;
    }

    @Override
    public int getReward() {
        return this.achReward ;
    }

    @Override
    public void setComplete() {
        this.achScript = "Completato";
        notifyObservers();
    }

    //METODI DELL' OBSERVER
    @Override
    public void attach(Observer obs) {
        this.achObservers.add(obs) ;
    }

    @Override
    public void detach(Observer obs) {
        this.achObservers.remove(obs) ;
    }

    @Override
    public void notifyObservers() {
        Iterator<Observer> i = achObservers.iterator();
        while (i.hasNext()) {
            Observer obs = i.next();
            obs.update();
        }
    }
}
