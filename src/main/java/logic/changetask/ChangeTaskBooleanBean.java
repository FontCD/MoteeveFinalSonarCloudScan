package logic.changetask;

//BEAN CONTENENTE LE INFORMAZIONI SUL CAMBIO TASK
public class ChangeTaskBooleanBean {
    //ATTRIBUTI
    boolean changeTaskResult;

    //METODI
    public void setBean(boolean changeTaskResult){
        this.changeTaskResult = changeTaskResult;
    }
    public boolean getBean(){
        return this.changeTaskResult;
    }
}
