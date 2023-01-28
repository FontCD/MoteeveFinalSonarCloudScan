package test;

import logic.Connectivity;
import logic.changetask.ChangeTaskCardBean;
import logic.changetask.ChangeTaskController;
import logic.changetask.ChangeTaskIdBean;
import logic.exceptions.NoChangeException;
import logic.model.Card;
import logic.viewcard.ViewCardController;
import logic.viewcard.ViewCardUserBean;
import logic.viewcurrenttasks.ViewCurrentTaskController;
import logic.viewcurrenttasks.ViewCurrentTaskListBean;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TestChangeTask {

    @Test
    public void testChangeTask() throws SQLException, IOException, NoChangeException {
        Connectivity.setConnection();

        int idToChange = 2;
        int changedId = 6;

        ViewCardController viewCardController = new ViewCardController();
        ViewCardUserBean cardBean = viewCardController.createCard();
        Card card = cardBean.getBean();

        ChangeTaskCardBean changeTaskCardBean = new ChangeTaskCardBean();
        changeTaskCardBean.setBean(card);
        ChangeTaskIdBean changeTaskIdBean = new ChangeTaskIdBean();
        changeTaskIdBean.setBean(idToChange);

        ChangeTaskController changeTaskController = new ChangeTaskController();
        changeTaskController.askForAChange(changeTaskCardBean,changeTaskIdBean);


        ChangeTaskIdBean changeNewTaskIdBean = new ChangeTaskIdBean();
        changeNewTaskIdBean.setBean(6);

        changeTaskController.changeTask(changeNewTaskIdBean);

        ViewCurrentTaskController viewCurrentTaskController = new ViewCurrentTaskController();
        ViewCurrentTaskListBean viewCurrentTaskListBean = viewCurrentTaskController.createTskList();

        assertEquals(changedId,viewCurrentTaskListBean.getBean().get(idToChange).getId());
    }
}
