package test;

import logic.Connectivity;
import logic.completeachievement.CompleteAchievementAchievementBean;
import logic.completeachievement.CompleteAchievementController;
import logic.completeachievement.CompleteAchievementStickerListBean;
import logic.factory.BaseObject;
import logic.factory.ObjectFactory;
import logic.viewstickers.ViewStickerListBean;
import logic.viewstickers.ViewStickersController;
import org.junit.Test;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

public class TestStickerUnlocked {

    //JUNIT TEST DI FEDERICO CANDELORI
    @Test
    public void testUnlock() throws SQLException, IOException {
        Connectivity.setConnection();

        ObjectFactory factory = new ObjectFactory();
        BaseObject ach = factory.createBaseObject(2,"Lvl100",  "Raggiungi il livello 100", "green", true, 2,"Ach");

        CompleteAchievementController controller = new CompleteAchievementController();
        CompleteAchievementAchievementBean bean = new CompleteAchievementAchievementBean();
        bean.setBean(ach);

        ViewStickersController controller2 = new ViewStickersController();
        ViewStickerListBean listBean = controller2.createStkList();

        CompleteAchievementStickerListBean listBeanForTest = new CompleteAchievementStickerListBean();
        listBeanForTest.setBean(listBean.getBean());

        controller.unlockAchievement(bean, listBeanForTest);
        assertTrue(listBean.getBean().get(1).getStatus());

    }

}
