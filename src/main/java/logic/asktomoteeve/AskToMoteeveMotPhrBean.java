package logic.asktomoteeve;

import logic.exceptions.InvalidStringException;

public class AskToMoteeveMotPhrBean {						//bean per il passaggio frase da stampare

    private String askToMoteevePhrase ;

    public void setBean(String askToMoteevePhrase) throws InvalidStringException {					//setter
        if (askToMoteevePhrase.length() == 0 || askToMoteevePhrase.length() >= 500){
            throw new InvalidStringException();
        } else {
            this.askToMoteevePhrase = askToMoteevePhrase;
        }
    }

    public String getBean() {								//getter
        return this.askToMoteevePhrase ;
    }
}
