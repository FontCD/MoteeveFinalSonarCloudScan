package logic.viewtasks;

import logic.dao.TaskDAOJDBC;
import logic.factory.BaseObject;
import logic.factory.ObjectFactory;
import java.util.ArrayList;
import java.util.List;

//CONTROLLER A CUI E' AFFIDATO IL COMPITO DI CREARE UNA LISTA DI TASK CON LE INFORAMZIONI RECUPERATE COL DATABASE
public class ViewTasksController {

    //METODO CHE CREA UNA LISTA DI TASK CON LE INFORMAZIONI RECUPERATE DAL DATABASE
    public ViewTasksListBean createTskList() {
        List<BaseObject> listTsk = new ArrayList<>();
        TaskDAOJDBC dao = new TaskDAOJDBC();
        ObjectFactory factory = new ObjectFactory();

        //------------DAILY---------------
        int dailyTskInd = 1;
        int maxDailyTsk = 6;

        do {
            String name = dao.extractName(dailyTskInd);
            String script = dao.extractScript(dailyTskInd);
            String color = dao.extractColor(dailyTskInd);
            boolean status = dao.extractStatus(dailyTskInd);
            int reward = dao.extractReward(dailyTskInd);


            BaseObject tsk = factory.createBaseObject(dailyTskInd, name, script, color, status, reward, "Task");
            listTsk.add(tsk);

            dailyTskInd = dailyTskInd + 1;

        } while (dailyTskInd != maxDailyTsk + 1);

        //-------------WEEKLY--------------------
        int weeklyTskInd = 1001;
        int maxWeeklyTsk = 1004;

        do {
            String name = dao.extractName(weeklyTskInd);
            String script = dao.extractScript(weeklyTskInd);
            String color = dao.extractColor(weeklyTskInd);
            boolean status = dao.extractStatus(weeklyTskInd);
            int reward = dao.extractReward(weeklyTskInd);


            BaseObject tsk = factory.createBaseObject(weeklyTskInd, name, script, color, status, reward, "Task");
            listTsk.add(tsk);

            weeklyTskInd = weeklyTskInd + 1;

        } while (weeklyTskInd != maxWeeklyTsk + 1);


        ViewTasksListBean bean = new ViewTasksListBean();
        bean.setBean(listTsk);

        return bean;
    }
}
