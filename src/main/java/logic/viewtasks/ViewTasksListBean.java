package logic.viewtasks;

import logic.factory.BaseObject;
import logic.model.Sticker;

import java.util.List;

public class ViewTasksListBean {
    private List<BaseObject> list;

    public void setBean(List<BaseObject> list) {
        this.list = list;
    }

    public List<BaseObject> getBean() {
        return this.list;
    }
}
