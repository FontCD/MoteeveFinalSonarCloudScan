package logic.observer;

//METODI DELLA CLASSE OSSERVATA
public interface Subject {
    public void attach(Observer obs) ;
    public  void detach(Observer obs);
    public void notifyObservers();
}
