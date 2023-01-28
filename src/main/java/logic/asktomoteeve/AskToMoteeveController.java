package logic.asktomoteeve;

import logic.dao.CoachDAOJDBC;
import logic.exceptions.InvalidStringException;


public class AskToMoteeveController {

    //---------------USER-----------
    public void askMotivationalPhrase()  {
        CoachDAOJDBC dao = new CoachDAOJDBC();
        dao.sendMotPhrRequest();
    }
    public AskToMoteeveMotPhrBean takeMotivationalPhrase() {
        CoachDAOJDBC dao = new CoachDAOJDBC();
        String motivationalPhrase = dao.takeMotivationalPhrase();
        AskToMoteeveMotPhrBean bean = new AskToMoteeveMotPhrBean();
        try {
            bean.setBean(motivationalPhrase);
        } catch (InvalidStringException e) {
            e.invalidStringMessage();
        }
        return bean;
    }

    public AskToMoteeveBooleanBean checkForAPhrase()  {
        CoachDAOJDBC dao = new CoachDAOJDBC();
        boolean result = dao.checkForAPhrase();
        AskToMoteeveBooleanBean bean = new AskToMoteeveBooleanBean();
        bean.setBean(result);
        return bean;
    }

    //----------COACH----------------
    public void insertMotivationalPhrase(AskToMoteeveMotPhrBean bean) {

        CoachDAOJDBC dao = new CoachDAOJDBC();
        dao.insertMotivationalPhrase(bean.getBean());
    }

    public AskToMoteeveBooleanBean checkRequest() {
        CoachDAOJDBC dao = new CoachDAOJDBC();
        boolean result = dao.checkRequest();
        AskToMoteeveBooleanBean bean = new AskToMoteeveBooleanBean();
        bean.setBean(result);
        return bean;
    }

}
