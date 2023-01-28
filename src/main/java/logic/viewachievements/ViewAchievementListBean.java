package logic.viewachievements;

import logic.factory.BaseObject;

import java.util.List;

//BEAN CONTENENTE LE INFORMAZIONI SULLA LISTA DI ACHIEVEMENTS
public class ViewAchievementListBean {

    //ATTRIBUTI
    private List<BaseObject> viewAchList;

    //METODI
    public void setBean(List<BaseObject> viewAchList) {
        this.viewAchList = viewAchList;
    }

    public List<BaseObject> getBean() {
        return this.viewAchList;
    }
}
