package logic.completeachievement;

import logic.model.Sticker;

import java.util.List;

//BEAN CONTENENTE LA LISTA DI STICKER RELATIVI AD OGNI ACHIEVEMENT
public class CompleteAchievementStickerListBean {

    //ATTRIBUTI
    private List<Sticker> completeAchievementStickerList;

    //METODI
    public void setBean(List<Sticker> completeAchievementStickerList) {
        this.completeAchievementStickerList = completeAchievementStickerList;
    }

    public List<Sticker> getBean(){
        return this.completeAchievementStickerList;
    }


}
