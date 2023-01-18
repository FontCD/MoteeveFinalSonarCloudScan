package logic.viewachievements;

import logic.factory.BaseObject;

import java.util.List;

public class ViewAchievementsListBean {
    private List<BaseObject> list;

    public void setBean(List<BaseObject> list) {
        this.list = list;
    }

    public List<BaseObject> getBean() {
        return this.list;
    }
}
