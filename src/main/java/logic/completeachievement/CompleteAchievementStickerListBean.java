package logic.completeachievement;

import logic.model.Sticker;

import java.util.List;

public class CompleteAchievementStickerListBean {

    private List<Sticker> completeAchievementStickerList;

    public void setBean(List<Sticker> completeAchievementStickerList) {
        this.completeAchievementStickerList = completeAchievementStickerList;
    }

    public List<Sticker> getBean(){
        return this.completeAchievementStickerList;
    }


}
