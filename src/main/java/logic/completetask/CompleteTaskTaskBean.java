package logic.completetask;

import logic.factory.BaseObject;

//BEAN CONTENENTE INFORMAZIONI SPECIFICHE SULLA TASK DA COMPLETARE
public class CompleteTaskTaskBean {

    //ATTRIBUTI
    private BaseObject completeTaskTask;

    //METODI
    public void setBean(BaseObject completeTaskTask) {
        this.completeTaskTask = completeTaskTask;
    }

    public BaseObject getBean() {
        return completeTaskTask;
    }
}
