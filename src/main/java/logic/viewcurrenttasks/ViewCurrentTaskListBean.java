package logic.viewcurrenttasks;

import logic.factory.BaseObject;

import java.util.List;

//BEAN CONTENENTE LE INFORMAZIONI RELATIVE ALLA LISTA DI TASK
public class ViewCurrentTaskListBean {

    //ATTRIBUTI
    private List<BaseObject> viewCurrentList;

    //METODI
    public void setBean(List<BaseObject> viewCurrentList) {
        this.viewCurrentList = viewCurrentList;
    }

    public List<BaseObject> getBean() {
        return this.viewCurrentList;
    }
}
