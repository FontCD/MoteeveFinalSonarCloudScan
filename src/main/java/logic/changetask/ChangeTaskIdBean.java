package logic.changetask;

//BEAN CONTENENTE INFORMAZIONI SULL' ID DELLA VECCHIA TASK DA CAMBIARE ALL' UTENTE CHE HA FATTO RICHIESTA DI CAMBIO DI TASK
public class ChangeTaskIdBean {

    //ATTRIBUTI
    private int changeTaskIndex;

    //METODI
    public void setBean(int changeTaskIndex){
        this.changeTaskIndex = changeTaskIndex;
    }

    public int getBean(){
        return this.changeTaskIndex;
    }
}
