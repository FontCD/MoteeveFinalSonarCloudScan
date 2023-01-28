package logic.viewstickers;

import logic.model.Sticker;

import java.util.List;

public class ViewStickerListBean {

    private List<Sticker> viewStickerList;

    public void setBean(List<Sticker> viewStickerList) {
        this.viewStickerList = viewStickerList;
    }

    public List<Sticker> getBean() {
        return this.viewStickerList;
    }

}
