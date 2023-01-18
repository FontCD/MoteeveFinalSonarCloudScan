package logic.factory;

import logic.model.Sticker;

public class StickerFactory {
    public Sticker createSticker(int id, String name, String stickerurl, boolean status){
        Sticker stk = new Sticker(id, name, stickerurl,status);

        return stk;
    }
}
