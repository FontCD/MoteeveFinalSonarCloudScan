package logic.changetask;

import logic.dao.CardDAOJDBC;
import logic.dao.TaskDAOJDBC;
import logic.exceptions.NoChangeException;
import logic.model.Card;

//CONTROLLER DEL CASO D'USO CHANGE TASK
public class ChangeTaskController {


    //----------USER-------------------
    //METODO PER CHIEDERE IL CAMBIO DI UNA TASK CHE NON SI VUOLE ESEGUIRE
    public void askForAChange(ChangeTaskCardBean cardBean,ChangeTaskIdBean idBean) throws NoChangeException {
        //VIENE ISTANZIATO IL DAO, RIEMPITO IL BEAN E CREATA UNA NUOVA CARD
        TaskDAOJDBC tskDao = new TaskDAOJDBC();
        int idToChange = idBean.getBean();
        Card card= cardBean.getBean();

        //CONTROLLO SUI CAMBI RIMANENTI PER LE TASK DA PARTE DELL' UTENTE
        if (card.getChange() != 0) {
            //LA NUOVA TASK VIENE SETTATA DAL COACH E IL NUMERO DI CAMBI VIENE DIMINUITO
            tskDao.insertTaskToChange(idToChange);
            CardDAOJDBC cardDao = new CardDAOJDBC();
            cardDao.decreaseChanges();
            card.decreaseChanges();

        } else {
            throw new NoChangeException();
        }
    }



    //----------COACH----------------------
    //METODO PER CONTROLLARE SE QUALCUNO HA RICHIESTO IL CAMBIO DI TASK
    public ChangeTaskBooleanBean checkForATaskRequest() {
        TaskDAOJDBC dao = new TaskDAOJDBC();
        boolean result = dao.checkForATaskRequest();
        ChangeTaskBooleanBean bean = new ChangeTaskBooleanBean();
        bean.setBean(result);
        return bean;
    }

    //METODO PER CAMBIARE LA TASK AD UN APPRENDISTA
    public void changeTask (ChangeTaskIdBean idBean) {
        //VENGONO PRESE INFORMAZIONI DAL BEAN
        int newIndex = idBean.getBean();
        //VIENE ISTANZIATO UN DAO
        TaskDAOJDBC tskDao = new TaskDAOJDBC();
        int idToChange = tskDao.getIdToChange();

        //CONTROLLO SE LA TASK DI CUI E' STATO RICHIESTO IL CAMBIO SIA GIORNALIERA O SETTIMANALE
        if(newIndex <= 1000)   {
            tskDao.insertNewTask(newIndex, idToChange,"Daily");
        } else {
            tskDao.insertNewTask(newIndex, idToChange,"Weekly");
        }
    }
}

