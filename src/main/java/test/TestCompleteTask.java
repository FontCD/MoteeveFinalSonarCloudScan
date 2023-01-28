package test;

import logic.Connectivity;
import logic.completetask.CompleteTaskController;
import logic.completetask.CompleteTaskIdCurrentBean;
import logic.completetask.CompleteTaskTaskBean;
import logic.completetask.CompleteTaskUserBean;
import logic.factory.BaseObject;
import logic.factory.ObjectFactory;
import logic.model.Card;
import logic.viewcard.ViewCardController;
import logic.viewcard.ViewCardUserBean;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class TestCompleteTask {

    @Test
    public void testCompleteTask() throws SQLException, IOException {
        Connectivity.setConnection();

        ObjectFactory tskFactory = new ObjectFactory();
        BaseObject tsk = tskFactory.createBaseObject(2, "Passeggiatore",  "Fai una passeggiata di almeno 20 minuti", "red", false, 150,"Task");

        ViewCardController controller1 = new ViewCardController();
        ViewCardUserBean cardBean = controller1.createCard();
        Card card = cardBean.getBean();

        CompleteTaskController controller2 = new CompleteTaskController();
        CompleteTaskTaskBean tskBean = new CompleteTaskTaskBean();
        tskBean.setBean(tsk);

        CompleteTaskUserBean userBean = new CompleteTaskUserBean();
        userBean.setBean(card);

        CompleteTaskIdCurrentBean idCurrentBean = new CompleteTaskIdCurrentBean();
        idCurrentBean.setBean(2);

        controller2.endTask(tskBean,userBean,idCurrentBean);

        assertTrue(tsk.getStatus());

    }


}
