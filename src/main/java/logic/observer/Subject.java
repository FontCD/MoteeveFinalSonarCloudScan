package logic.observer;

//METODI DELLA CLASSE OSSERVATA
public interface Subject {

    //METODO PER ATTACCARE L' OBSERVER ALL' OGGETTO OSSERVATO
    public void attach(Observer obs) ;
    //METODO PER STACCARE L' OBSERVER DALL' OGGETTO OSSERVATO
    public  void detach(Observer obs);
    //METODO PER NOTIFICARE GLI OBSERVER
    public void notifyObservers();
}
