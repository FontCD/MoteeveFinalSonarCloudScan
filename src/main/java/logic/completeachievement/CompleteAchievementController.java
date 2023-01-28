package logic.completeachievement;

import logic.dao.AchievementDAOJDBC;
import logic.dao.StickerDAOJDBC;
import logic.factory.BaseObject;
import logic.model.Sticker;

import java.util.List;

public class CompleteAchievementController {

    public void unlockAchievement(CompleteAchievementAchievementBean achBean, CompleteAchievementStickerListBean stickerListBean) {

        BaseObject ach = achBean.getBean() ;


        if (ach.getStatus()){

            List<Sticker> list = stickerListBean.getBean();

            ach.setComplete() ;
            int stkIndex = ach.getReward();
            list.get(stkIndex-1).setOwned();

            updateDB(stkIndex,ach.getId());

        } else {
            System.out.println("Non puoi ancora completare questo achievement");
        }
    }

    private void updateDB(int stkIndex, int achIndex) {
        StickerDAOJDBC stkDao = new StickerDAOJDBC();
        AchievementDAOJDBC achDao = new AchievementDAOJDBC();

        stkDao.setOwned(stkIndex);
        achDao.setComplete(achIndex);
        }
}
