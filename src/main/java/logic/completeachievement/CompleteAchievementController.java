package logic.completeachievement;

import logic.dao.AchievementDAOJDBC;
import logic.dao.StickerDAOJDBC;
import logic.factory.BaseObject;
import logic.model.Sticker;

import java.util.List;

//CONTROLLER DEL CASO D'USO COMPLETE ACHIEVEMENT
public class CompleteAchievementController {

    //METODO PER COMPLETARE UN ACHIEVEMENT
    public void unlockAchievement(CompleteAchievementAchievementBean achBean, CompleteAchievementStickerListBean stickerListBean) {

        BaseObject ach = achBean.getBean();

        //CONTROLLO SUL CORRETTO COMPLETAMENTO DELL' ACHIEVEMENT
        if (ach.getStatus()) {

            List<Sticker> list = stickerListBean.getBean();
            //L' ACHIEVEMENT VIENE SETTATO COME COMPLETATO
            ach.setComplete();
            //LO STICKER ASSOCIATO VIENE CONSEGNATO ALL' UTENTE
            int stkIndex = ach.getReward();
            list.get(stkIndex - 1).setOwned();
            //IL DATABASE VIENE AGGIORNATO CON LE INFORMAZIONI RELATIVE ALLO SBLOCCO DEL NUOVO STICKER
            updateDB(stkIndex, ach.getId());

        } else {
            System.out.println("Non puoi ancora completare questo achievement");
        }
    }

    //METODO PER SETTARE L' ACHIEVEMENT COME COMPLETATO NEL DATABASE
    private void updateDB(int stkIndex, int achIndex) {
        //ISTANZIO I DAO
        StickerDAOJDBC stkDao = new StickerDAOJDBC();
        AchievementDAOJDBC achDao = new AchievementDAOJDBC();
        //AGGIORNO IL DB
        stkDao.setOwned(stkIndex);
        achDao.setComplete(achIndex);
    }
}
