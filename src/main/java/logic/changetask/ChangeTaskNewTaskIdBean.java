package logic.changetask;

//BEAN CONTENENTE LE INFORMAZIONI SULL' ID DELLA NUOVA TASK DA ASSEGNARE ALL' UTENTE CHE HA FATTO RICHIESTA DEL CAMBIO DI TASK
public class ChangeTaskNewTaskIdBean {

    //ATTRIBUTI
    private int changeTaskNewTaskId;

    //METODI
    public void setBean(int changeTaskNewTaskId) {
        this.changeTaskNewTaskId = changeTaskNewTaskId;
    }

    public int getBean() {
        return this.changeTaskNewTaskId;
    }

}
