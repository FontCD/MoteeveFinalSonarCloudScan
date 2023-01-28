package logic.changetask;

import logic.factory.BaseObject;

import java.util.List;

public class ChangeTaskListBean {
    private List<BaseObject> changeTaskTskList;

    public void setBean(List<BaseObject> changeTaskTskList) {
        this.changeTaskTskList = changeTaskTskList;
    }

    public List<BaseObject> getBean() {
        return changeTaskTskList;
    }

}
