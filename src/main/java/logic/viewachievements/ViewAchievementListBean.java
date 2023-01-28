package logic.viewachievements;

import logic.factory.BaseObject;

import java.util.List;

public class ViewAchievementListBean {
    private List<BaseObject> viewAchList;

    public void setBean(List<BaseObject> viewAchList) {
        this.viewAchList = viewAchList;
    }

    public List<BaseObject> getBean() {
        return this.viewAchList;
    }
}
