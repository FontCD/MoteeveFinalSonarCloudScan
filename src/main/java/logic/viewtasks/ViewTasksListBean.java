package logic.viewtasks;

import logic.factory.BaseObject;

import java.util.List;

public class ViewTasksListBean {
    private List<BaseObject> viewTaskList ;

    public void setBean(List<BaseObject> viewTaskList) {
        this.viewTaskList = viewTaskList;
    }
    public List<BaseObject> getBean() {
        return this.viewTaskList;
    }
}
