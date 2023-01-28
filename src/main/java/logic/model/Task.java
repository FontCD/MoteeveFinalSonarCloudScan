package logic.model;

import logic.factory.BaseObject;
import logic.observer.Observer;
import logic.observer.Subject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//ENTITY TASK
public class Task implements BaseObject, Subject {

    //ATTRIBUTI
    private List<Observer> observers = new ArrayList<>();
    private int id;
    private String name;
    private String script;
    private String color ;
    private boolean status;
    private int reward ;

    //COSTRUTTORE COMPLETO
    public Task (int id, String name, String script, String color,boolean status, int reward) { 	//costruttore completo
        this.id = id;
        this.name = name ;
        this.script = script ;
        this.color = color ;
        this.status = status ;
        this.reward = reward ;

    }

    //METODI ENTITY
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

    //METODI OBSERVER
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
