package logic.viewtasks;

import logic.factory.BaseObject;

import java.util.List;

//BEAN CONTENENTE LE INFORMAZIONI RELATIVE ALLE LISTE DI TASK
public class ViewTasksListBean {

    //ATTRIBUTI
    private List<BaseObject> viewTaskList ;

    //METODI
    public void setBean(List<BaseObject> viewTaskList) {
        this.viewTaskList = viewTaskList;
    }
    public List<BaseObject> getBean() {
        return this.viewTaskList;
    }
}
