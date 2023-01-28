package logic.viewcurrenttasks;

import logic.factory.BaseObject;

import java.util.List;

public class ViewCurrentTaskListBean {
    private List<BaseObject> viewCurrentList;

    public void setBean(List<BaseObject> viewCurrentList) {
        this.viewCurrentList = viewCurrentList;
    }

    public List<BaseObject> getBean() {
        return this.viewCurrentList;
    }
}
