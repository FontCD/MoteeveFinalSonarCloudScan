package logic.factory;

import logic.observer.Subject;


//BASE OBJECT DEL METODO FACTORY
public interface BaseObject extends Subject {

    //METODI
    int getId() ;

    String getName() ;

    String getScript() ;

    boolean getStatus() ;

    String getColor();

    int getReward() ;

    void setComplete();

}
