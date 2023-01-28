package logic.model;

//ENTITY STICKER
public class Sticker {

    //ATTRIBUTI
    private int id;
    private String name ;
    private String stickerurl;
    private boolean status ;

    //COSTRUTTORE COMPLETO
    public Sticker (int id, String name, String stickerurl, boolean status) {
        this.id = id ;
        this.name = name;
        this.stickerurl = stickerurl ;
        this.status = status ;
    }

    //METODI ENTITY
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

