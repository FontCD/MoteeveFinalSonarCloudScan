package logic.completetask;

import logic.factory.BaseObject;

public class CompleteTaskTaskBean {

    private BaseObject task;

    public void setBean(BaseObject newTask) {
        this.task = newTask;
    }

    public BaseObject getBean() {
        return task;
    }
}
