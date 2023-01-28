package logic.asktomoteeve;

import logic.dao.CoachDAOJDBC;
import logic.exceptions.InvalidStringException;


//CONTROLLER DEL CASO D'USO ASK TO MOTEEVE
public class AskToMoteeveController {

    //---------------USER-----------
    //METODO PER CHIEDERE UNA FRASE AL COACH
    public void askMotivationalPhrase()  {
        CoachDAOJDBC dao = new CoachDAOJDBC();
        dao.sendMotPhrRequest();
    }

    //METODO PER PRELEVARE UNA FRASE MOTIVAZIONALE
    public AskToMoteeveMotPhrBean takeMotivationalPhrase() {
        //DAO VIENE ISTANZIATO
        CoachDAOJDBC dao = new CoachDAOJDBC();
        //IL BEAN VIENE CARICATO CON LE INFORMAZIONI NECESSARIE
        String motivationalPhrase = dao.takeMotivationalPhrase();
        AskToMoteeveMotPhrBean bean = new AskToMoteeveMotPhrBean();
        //CONTROLLO SULLA STRINGA CONTENENTE IL MESSAGGIO
        try {
            bean.setBean(motivationalPhrase);
        } catch (InvalidStringException e) {
            e.invalidStringMessage();
        }
        //RITORNO DEL BEAN CON LE INFO NECESSARIE
        return bean;
    }

    //METODO PER CONTROLLARE SE SONO ARRIVATE FRASI MOTIVAZIONALI DA PARTE DEL COACH
    public AskToMoteeveBooleanBean checkForAPhrase()  {
        //DAO E BEAN VENGONO ISTANZIATI
        CoachDAOJDBC dao = new CoachDAOJDBC();
        boolean result = dao.checkForAPhrase();
        AskToMoteeveBooleanBean bean = new AskToMoteeveBooleanBean();
        //IL BEAN VIENE CARICATO CON LE INFORMAZIONI NECESSARIE
        bean.setBean(result);
        //RITORNO DEL BEAN CON LE INFO NECESSARIE
        return bean;
    }

    //----------COACH----------------
    //METODO PER IL COACH PER INSERIRE LA FRASE MOTIVAZIONALE RICHIESTA DAL SUO APPRENDISTA
    public void insertMotivationalPhrase(AskToMoteeveMotPhrBean bean) {

        CoachDAOJDBC dao = new CoachDAOJDBC();
        dao.insertMotivationalPhrase(bean.getBean());
    }

    //METODO PER CONTROLLARE SE CI SONO RICHIESTE DI FRASI DA PARTE DEGLI UTENTI
    public AskToMoteeveBooleanBean checkRequest() {
        //DAO E BEAN VENGONO ISTANZIATI
        CoachDAOJDBC dao = new CoachDAOJDBC();
        boolean result = dao.checkRequest();
        AskToMoteeveBooleanBean bean = new AskToMoteeveBooleanBean();
        //IL BEAN VIENE CARICATO CON LE INFORMAZIONI NECESSARIE
        bean.setBean(result);
        //RITORNO DEL BEAN
        return bean;
    }

}
