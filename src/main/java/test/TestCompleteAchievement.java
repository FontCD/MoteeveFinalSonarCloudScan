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

import static org.junit.Assert.assertEquals;

public class TestCompleteAchievement {

    //Questo test è stato sviluppato da Lorenzo Brunori
    //Il test verifica che il controller del caso d'uso complete achievement effettivamente completi la task
    @Test
    public void testCompleteAchievement() throws SQLException, IOException {
        Connectivity.setConnection();

        ObjectFactory objectFactory = new ObjectFactory();
        BaseObject ach = objectFactory.createBaseObject(1,"Benvenuto",  "Utilizza Moteeve per la prima volta", "gray", true, 1,"Ach");

        CompleteAchievementController completeAchievementController = new CompleteAchievementController();
        CompleteAchievementAchievementBean bean = new CompleteAchievementAchievementBean();
        bean.setBean(ach);

        ViewStickersController viewStickersController = new ViewStickersController();
        ViewStickerListBean listBean = viewStickersController.createStkList();

        CompleteAchievementStickerListBean listBeanForTest = new CompleteAchievementStickerListBean();
        listBeanForTest.setBean(listBean.getBean());

        completeAchievementController.unlockAchievement(bean,listBeanForTest);
        assertEquals("Completato", ach.getScript());
    }
}
