package logic.model;


public class Sticker {																			//Entity

    private int id;
    private String name ;
    private String stickerurl;
    private boolean status ;

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

    public void setOwned(){
        this.status = true;
    }
}

