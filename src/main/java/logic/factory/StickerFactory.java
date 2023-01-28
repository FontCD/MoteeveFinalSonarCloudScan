package logic.factory;

import logic.model.Sticker;

//PATTERN FACTORY APPLICATO ALLA CLASSE STICKER
public class StickerFactory {
    //METODO PER CREARE UNO STICKER SECONDO IL PATTERN FACTORY
    public Sticker createSticker(int id, String name, String stickerurl, boolean status){

        return new Sticker(id, name, stickerurl,status);
    }
}
