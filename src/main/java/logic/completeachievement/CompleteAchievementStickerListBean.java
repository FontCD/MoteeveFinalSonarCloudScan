package logic.completeachievement;

import logic.model.Sticker;

import java.util.List;

public class CompleteAchievementStickerListBean {

    private List<Sticker> stickerList;

    public void setBean(List<Sticker> stickerList) {
        this.stickerList = stickerList;
    }

    public List<Sticker> getBean(){
        return this.stickerList;
    }


}
