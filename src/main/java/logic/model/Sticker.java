package logic.model;

import logic.dao.StickerDAOJDBC;

public class Sticker {																			//Entity

    private int id;
    private String name ;
    private String stickerurl;
    private boolean status ;

    //da eliminare quando setstkbyid viene emessa nel dao
    public Sticker(){};

    public Sticker (int id, String name, String stickerurl, boolean status) {
        this.id = id ;
        this.name = name;
        this.stickerurl = stickerurl ;
        this.status = status ;
    }

    public int getId(){
        return this.id;
    }
    public String getName() {
        return  this.name;
    }

    public String getStickerUrl() {
        return  this.stickerurl;

    }

    public boolean getStatus() {
        return  this.status;
    }

    public void setOwned() throws Exception {
        this.status = true;
    }

    //da eliminare e mettere nel dao

    public void setStickerById(int index) throws Exception {
        StickerDAOJDBC dao = new StickerDAOJDBC() ;
        this.id = index;
        this.name = dao.extractName(index);
        this.stickerurl = dao.extractStickerUrl(index);
        this.status = dao.extractStatus(index);

    }

}

