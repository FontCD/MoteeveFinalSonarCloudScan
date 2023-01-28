package logic.asktomoteeve;

import logic.exceptions.InvalidStringException;


//BEAN PER IL PASSAGGIO DELLE FRASI MOTIVAZIONALI
public class AskToMoteeveMotPhrBean {

    //STRINGA CONTENENTE LA FRASE
    private String askToMoteevePhrase ;

    //SETTER DEL BEAN
    public void setBean(String askToMoteevePhrase) throws InvalidStringException {
        //CONTROLLO SULLA CORRETTEZZA DELLA STRINGA INSERITA
        if (askToMoteevePhrase.length() == 0 || askToMoteevePhrase.length() >= 500){
            throw new InvalidStringException();
        } else {
            this.askToMoteevePhrase = askToMoteevePhrase;
        }
    }

    //METODO GET PER IL BEAN
    public String getBean() {								//getter
        return this.askToMoteevePhrase ;
    }
}
