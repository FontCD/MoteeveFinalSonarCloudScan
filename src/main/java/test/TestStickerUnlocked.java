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

    //JUNIT TEST BY FEDERICO CANDELORI
    //QUESTO TEST SERVE A VERIFICARE IL CORRETTO SBLOCCO DI UNO STICKER IN SEGUITO AL COMPLEATMENTO DI UN
    // ACHIEVEMENT DA PARTE DELL' UTENTE
    @Test
    public void testUnlock() throws SQLException, IOException {
        //CONNESSIONE AL DATABASE
        Connectivity.setConnection();
        //TRAMITE PATTERN FACTORY CREO UN ACHIEVEMENT FITTIZIO
        ObjectFactory factory = new ObjectFactory();
        BaseObject ach = factory.createBaseObject(2,"Lvl100",  "Raggiungi il livello 100", "green", true, 2,"Ach");

        //ISTANZIO BEAN E CONTROLLER DEL CASO COMPLETE ACHIEVEMENT PER SIMULARE IL COMPLETAMENTO DI
        // QUEST' ULTIMO E RICEVERE DI CONSEGUENZA IL RISPETTIVO STICKER
        CompleteAchievementController controller = new CompleteAchievementController();
        CompleteAchievementAchievementBean bean = new CompleteAchievementAchievementBean();
        bean.setBean(ach);

        //CREO UNA LISTA DEGLI STICKERS SBLOCCATI IN SEGUITO AL COMPLETAMENTO DEGLI ACHIEVEMENT
        //ISTANZIO LA LISTVIEW DEGLI STICKER PER VEDERE QUALI EFFETTIVAMENTE SONO STATI SBLOCCATI (IN QUESTO CASO SOLO QUELLO DELL' ACHIEVEMENT CORRENTE)
        ViewStickersController controller2 = new ViewStickersController();
        ViewStickerListBean listBean = controller2.createStkList();
        CompleteAchievementStickerListBean listBeanForTest = new CompleteAchievementStickerListBean();
        listBeanForTest.setBean(listBean.getBean());

        //TESTO SE LO STICKER SBLOCCATO E' LO STESSO DI QUELLO ASSOCIATO ALL' ACHIEVEMENT COMPLETATO
        controller.unlockAchievement(bean, listBeanForTest);
        assertTrue(listBean.getBean().get(1).getStatus());

    }

}
