package logic.completetask;

import logic.dao.CardDAOJDBC;
import logic.dao.TaskDAOJDBC;
import logic.factory.BaseObject;
import logic.model.Card;

//CONTROLLER DEL CASO D'USO COMPLETE TASK
public class CompleteTaskController {

    //METODO PER COMPLETARE UNA TASK
    public void endTask(CompleteTaskTaskBean taskBean, CompleteTaskUserBean userBean, CompleteTaskIdCurrentBean idCurrentBean) {
        //ISTANZIO IL DAO E RICAVO L' ID DELLA TASK DA COMPLETARE TRAMITE BEAN
        TaskDAOJDBC dao = new TaskDAOJDBC();
        int idCurrent = idCurrentBean.getBean();

        //CONTROLLO SULLA CORRETTA ATTIVAZIONE DELLA TASK CORRENTE
        if (!dao.isExpired(idCurrent)) {

            //VENGONO PRELEVATE INFO DAL BEAN
            BaseObject task = taskBean.getBean();
            Card card = userBean.getBean();

            //LO STATO DELLA TASK VIENE AGGIORNATO
            task.setComplete();

            //LA RICOMPENSA VIENE ASSEGNATA ALLO USER
            int reward = task.getReward();
            card.addReward(reward);

            updateDB(reward, task.getId());
        }
    }

    //METODO PER FARE L' UPDATE DEL DATABASE CON LA RICOMPENSA ASSEGNATA E PER SETTARE LA TASK CON L'ID CORRISPONDENTE COME COMPLETATA
    private void updateDB ( int reward, int taskId) {
        //ISTANZIO I VARI DAO E AGGIORNO LE INFORMAZIONI
        CardDAOJDBC cardDao = new CardDAOJDBC();
        cardDao.addExp(reward);
        TaskDAOJDBC taskDao = new TaskDAOJDBC();
        taskDao.setComplete(taskId);
    }
}
