package logic.viewachievements;

import logic.dao.AchievementDAOJDBC;
import logic.factory.BaseObject;
import logic.factory.ObjectFactory;
import logic.observer.AchievementObserver;
import java.util.ArrayList;
import java.util.List;

//CONTROLLER DELLA VIEW DEGLI ACHIEVEMENTS
public class ViewAchievementController {

    //CREAZIONE DI UNA LISTA DI ACHIEVEMENTS (RECUPERATI DAL DB)
    public ViewAchievementListBean createAchList() {
        int achInd = 1;
        int maxAch = 11;
        List<BaseObject> listAch = new ArrayList<>();

        AchievementDAOJDBC dao = new AchievementDAOJDBC();
        ObjectFactory factory = new ObjectFactory();

        do {
            String name = dao.extractName(achInd);
            String script = dao.extractScript(achInd);
            String color = dao.extractColor(achInd);
            boolean status = dao.extractStatus(achInd);
            int reward = dao.extractReward(achInd);

            BaseObject ach = factory.createBaseObject(achInd, name, script, color, status, reward, "Ach");
            listAch.add(ach);

            AchievementObserver obs = new AchievementObserver(ach);
            ach.attach(obs);

            achInd = achInd + 1;

        } while (achInd != maxAch + 1);

        ViewAchievementListBean bean = new ViewAchievementListBean();
        bean.setBean(listAch);

        return bean;
    }
}
