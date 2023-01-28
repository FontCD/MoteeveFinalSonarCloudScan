package logic.viewstickers;

import logic.model.Sticker;

import java.util.List;

//BEAN CONTENENETE LE INFORMAZIONI RELATIVE ALLE LISTE DI STICKER
public class ViewStickerListBean {

    //ATTRIBUTI
    private List<Sticker> viewStickerList;

    //METODI
    public void setBean(List<Sticker> viewStickerList) {
        this.viewStickerList = viewStickerList;
    }

    public List<Sticker> getBean() {
        return this.viewStickerList;
    }

}
