package logic.asktomoteeve;

//BEAN CONTENTE L'INFORMAZIONE SULLA PRESENZA POSITIVA O NEGATIVA DI FRASI MOTIVAZIONALI DA PARTE DEL COACH
public class AskToMoteeveBooleanBean {

    //PARAMETRI DEL BEAN
    private boolean askToMoteeveResult;

    //METODI DEL BEAN
    public void setBean(boolean askToMoteeveResult){
        this.askToMoteeveResult = askToMoteeveResult;
    }
    public boolean getBean(){
        return this.askToMoteeveResult;
    }

}
