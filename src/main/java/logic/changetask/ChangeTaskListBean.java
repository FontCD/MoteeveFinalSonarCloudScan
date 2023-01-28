package logic.changetask;

import logic.factory.BaseObject;

import java.util.List;

//BEAN CONTENENTE INFORMAZIONI SULLE TASK DA CUI IL COACH PUO' SCEGLIERE QUELLA SOSTITUTIVA A QUELLA CHE L' UTENTE VUOLE CAMBIARE
public class ChangeTaskListBean {

    //ATTRIBUTI
    private List<BaseObject> changeTaskTskList;

    //METODI
    public void setBean(List<BaseObject> changeTaskTskList) {
        this.changeTaskTskList = changeTaskTskList;
    }

    public List<BaseObject> getBean() {
        return changeTaskTskList;
    }

}
