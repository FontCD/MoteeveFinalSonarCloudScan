package logic.changetask;

import logic.dao.CardDAOJDBC;
import logic.dao.TaskDAOJDBC;
import logic.exceptions.NoChangeException;
import logic.model.Card;


public class ChangeTaskController {


    //----------USER-------------------
    public void askForAChange(ChangeTaskCardBean cardBean,ChangeTaskIdBean idBean) throws NoChangeException {
        TaskDAOJDBC tskDao = new TaskDAOJDBC();

        int idToChange = idBean.getBean();
        Card card= cardBean.getBean();

        if (card.getChange() != 0) {

            tskDao.insertTaskToChange(idToChange);
            CardDAOJDBC cardDao = new CardDAOJDBC();
            cardDao.decreaseChanges();
            card.decreaseChanges();

        } else {
            throw new NoChangeException();
        }
    }



    //----------COACH----------------------
    public ChangeTaskBooleanBean checkForATaskRequest() {
        TaskDAOJDBC dao = new TaskDAOJDBC();
        boolean result = dao.checkForATaskRequest();
        ChangeTaskBooleanBean bean = new ChangeTaskBooleanBean();
        bean.setBean(result);
        return bean;
    }

    public void changeTask (ChangeTaskIdBean idBean) {
        int newIndex = idBean.getBean();

        TaskDAOJDBC tskDao = new TaskDAOJDBC();
        int idToChange = tskDao.getIdToChange();

        if(newIndex <= 1000)   {
            tskDao.insertNewTask(newIndex, idToChange,"Daily");
        } else {
            tskDao.insertNewTask(newIndex, idToChange,"Weekly");
        }
    }
}

