package logic.viewtasks;

import logic.dao.TaskDAOJDBC;
import logic.factory.BaseObject;
import logic.factory.ObjectFactory;
import logic.observer.TaskObserver;

import java.util.ArrayList;
import java.util.List;

public class ViewTasksController {

    public ViewTasksListBean createTskList() throws Exception {
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

        ViewTasksListBean bean = new ViewTasksListBean();
        bean.setBean(listTsk);

        return bean;
    }
}
