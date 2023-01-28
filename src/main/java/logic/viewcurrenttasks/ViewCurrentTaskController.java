package logic.viewcurrenttasks;

import logic.dao.TaskDAOJDBC;
import logic.factory.BaseObject;
import logic.factory.ObjectFactory;
import logic.observer.TaskObserver;
import java.util.ArrayList;
import java.util.List;

//CONTROLLER A CUI E' AFFIDATA LA CREAZIONE DELLA LISTA DI TASK RECUPERATE DAL DATABASE
public class ViewCurrentTaskController {

    //METODO PER CREARE LA LISTA DI TASK RECUPERATE DAL DATABASE
    public ViewCurrentTaskListBean createTskList() {
        int tskInd = 1;
        int maxTsk = 6;
        List<BaseObject> listTsk = new ArrayList<>();

        TaskDAOJDBC dao = new TaskDAOJDBC();
        ObjectFactory factory = new ObjectFactory();

        do {
            String name = dao.extractNameCurrent(tskInd);
            String script = dao.extractScriptCurrent(tskInd);
            String color = dao.extractColorCurrent(tskInd);
            boolean status = dao.extractStatusCurrent(tskInd);
            int reward = dao.extractRewardCurrent(tskInd);


            BaseObject tsk = factory.createBaseObject(tskInd, name, script, color, status, reward, "Task");
            listTsk.add(tsk);

            TaskObserver obs = new TaskObserver(tsk);
            tsk.attach(obs);

            tskInd = tskInd + 1;

        } while (tskInd != maxTsk + 1);

        ViewCurrentTaskListBean bean = new ViewCurrentTaskListBean();
        bean.setBean(listTsk);

        return bean;
    }
}
