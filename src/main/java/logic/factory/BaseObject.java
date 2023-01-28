package logic.factory;

import logic.observer.Subject;



public interface BaseObject extends Subject {

    int getId() ;

    String getName() ;

    String getScript() ;

    boolean getStatus() ;

    String getColor();

    int getReward() ;

    void setComplete();

}
