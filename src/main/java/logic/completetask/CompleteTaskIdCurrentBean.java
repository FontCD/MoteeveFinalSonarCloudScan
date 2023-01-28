package logic.completetask;

//BEAN CONTENENTE INFORMAZIONI RELATIVE ALL' ID DELLA TASK DA COMPLETARE
public class CompleteTaskIdCurrentBean {

    //ATTRIBUTI
    private int completeTaskIdCurrent;

    //METODI
    public void setBean(int completeTaskIdCurrent) {
        this.completeTaskIdCurrent = completeTaskIdCurrent;
    }

    public int getBean(){
        return this.completeTaskIdCurrent;
    }
}
