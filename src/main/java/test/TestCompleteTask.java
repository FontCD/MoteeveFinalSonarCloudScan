package test;

import logic.Connectivity;
import logic.completetask.CompleteTaskController;
import logic.completetask.CompleteTaskTaskBean;
import logic.factory.BaseObject;
import logic.factory.CardFactory;
import logic.factory.ObjectFactory;

import java.io.IOException;
import java.sql.SQLException;

public class TestCompleteTask {

    public void testCompleteTask() throws SQLException, IOException {
        Connectivity.setConnection();

        ObjectFactory tskFactory = new ObjectFactory();
        BaseObject tsk = tskFactory.createBaseObject(2, "Passeggiatore",  "Fai una passeggiata di almeno 20 minuti", "red", false, 150,"Task");

        

        CompleteTaskController controller = new CompleteTaskController();
        CompleteTaskTaskBean tskBean = new CompleteTaskTaskBean();


        tskBean.setBean(tsk);
        //controller.endTask(tskBean,);

    }


}
