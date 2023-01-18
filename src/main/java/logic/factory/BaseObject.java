package logic.factory;

import logic.observer.Subject;

import java.util.List;

public interface BaseObject extends Subject {

    void setObject(int id, String name, String script, String color, boolean status, int reward);

    int getId() ;

    String getName() ;

    String getScript() ;

    String getColor() ;

    boolean getStatus() ;

    int getReward() ;

    void setComplete() throws Exception ;
    void setCompletable() ;

    void setBaseObjectById(int index) throws Exception;
}
