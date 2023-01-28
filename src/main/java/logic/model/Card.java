package logic.model;

import java.util.ArrayList;
import java.util.List;

//ENTITY CARD
public class Card {

    //ATTRIBUTI
    private String username;
    private int exp;
    private int level;
    private int changes;
    private String profileImage;
    private List<Sticker> slots = new ArrayList<>();

    //COSTRUTTORE COMPLETO DI CARD
    public Card(String userName, int exp, int level, int changes,String profileImage,List<Sticker> slots) {
        this.username = userName;
        this.exp = exp;
        this.level = level;
        this.changes = changes;
        this.profileImage = profileImage;
        this.slots = slots;
    }

    //METODI ENTITY
    public String getUserName() {
        return this.username;
    }

    public int getExp() {
        return this.exp;
    }

    public int getLevel() {
        return this.level;
    }
    public List<Sticker> getSlots() {return this.slots;}

    public String getProfileImage() {
        return this.profileImage;
    }

    public int getChange() {
        return this.changes;
    }

    public void decreaseChanges() {
        this.changes = this.changes - 1;
    }

    public void addReward(int exp){
        this.exp = this.exp + exp;
    }

    public void changeUsername(String username) {
        this.username = username;
    }

}
