package logic.completetask;

import logic.dao.CardDAOJDBC;
import logic.dao.TaskDAOJDBC;

import logic.factory.BaseObject;
import logic.model.Card;


public class CompleteTaskController {
    public void endTask(CompleteTaskTaskBean taskBean, CompleteTaskCardBean userBean, CompleteTaskIdCurrentBean idCurrentBean) throws Exception {
            TaskDAOJDBC dao = new TaskDAOJDBC();
            int idCurrent = idCurrentBean.getBean();

            if (!dao.isExpired(idCurrent)) {

                BaseObject task = taskBean.getBean();          //prendo i dati dai bean
                Card card = userBean.getBean();


                task.setComplete();                     //dalla Enity aggiorno lo stato della task

                int reward = task.getReward();          //prendo la reward
                card.addReward(reward);                 //la inserisco nello user


                updateDB(reward, task.getId(), idCurrent);
            } else {
                System.out.println("Non puoi, the task is expired");
            }
        }

        private void updateDB(int reward, int taskId, int idCurrent) throws Exception {
            CardDAOJDBC userDao = new CardDAOJDBC();
            userDao.addExp(reward);

            TaskDAOJDBC taskDao = new TaskDAOJDBC();
            taskDao.setComplete(idCurrent,taskId);
        }
}
