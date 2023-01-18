package logic.viewachievements;

import logic.dao.AchievementDAOJDBC;
import logic.dao.TaskDAOJDBC;
import logic.factory.BaseObject;
import logic.factory.ObjectFactory;
import logic.observer.TaskObserver;

import java.util.ArrayList;
import java.util.List;

public class ViewAchievementsController {

    public ViewAchievementsListBean createAchList() throws Exception {
        int achInd = 1;
        int maxAch = 3;
        List<BaseObject> listAch = new ArrayList<>();

        AchievementDAOJDBC dao = new AchievementDAOJDBC();
        ObjectFactory factory = new ObjectFactory();

        do {
            String name = dao.extractName(achInd);
            String script = dao.extractScript(achInd);
            String color = dao.extractColor(achInd);
            boolean status = dao.extractStatus(achInd);
            int reward = dao.extractReward(achInd);


            BaseObject tsk = factory.createBaseObject(achInd, name, script, color, status, reward, "Task");
            listAch.add(tsk);

            TaskObserver obs = new TaskObserver(tsk);
            tsk.attach(obs);

            achInd = achInd + 1;

        } while (achInd != maxAch + 1);

        ViewAchievementsListBean bean = new ViewAchievementsListBean();
        bean.setBean(listAch);

        return bean;
    }
}
