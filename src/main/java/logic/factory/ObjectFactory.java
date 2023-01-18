package logic.factory;

import logic.model.Achievement;
import logic.model.Task;

public class ObjectFactory {
    public BaseObject createBaseObject(int id, String name, String script, String color,boolean status, int reward, String type) throws Exception {

        switch (type) {
            case "Ach":
                return new Achievement(id,name,script, color,status,reward);
            case "Task":
                return new Task(id,name,script, color,status,reward) ;
            default:
                throw new Exception("Type not found");
        }
    }
}
