package logic.completetask;

import logic.dao.CardDAOJDBC;
import logic.dao.TaskDAOJDBC;
import logic.factory.BaseObject;
import logic.model.Card;


public class CompleteTaskController {
    public void endTask(CompleteTaskTaskBean taskBean, CompleteTaskUserBean userBean, CompleteTaskIdCurrentBean idCurrentBean) {
        TaskDAOJDBC dao = new TaskDAOJDBC();
        int idCurrent = idCurrentBean.getBean();

        if (!dao.isExpired(idCurrent)) {

            BaseObject task = taskBean.getBean();          //prendo i dati dai bean
            Card card = userBean.getBean();


            task.setComplete();                     //dalla Enity aggiorno lo stato della task

            int reward = task.getReward();          //prendo la reward
            card.addReward(reward);                 //la inserisco nello user

            updateDB(reward, task.getId());
        }
    }
        private void updateDB ( int reward, int taskId){
            CardDAOJDBC cardDao = new CardDAOJDBC();
            cardDao.addExp(reward);

            TaskDAOJDBC taskDao = new TaskDAOJDBC();
            taskDao.setComplete(taskId);
        }

}
