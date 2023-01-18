package logic.model;

import java.util.ArrayList;
import java.util.List;

public class Card {

    private String userName;
    private int exp;
    private int level;
    private int changes;

    private String profileImage;

    private List<Sticker> slots = new ArrayList<>();

    public Card(String userName, int exp, int level, int changes,String profileImage,List<Sticker> slots) {
        this.userName = userName;
        this.exp = exp;
        this.level = level;
        this.changes = changes;
        this.profileImage = profileImage;
        this.slots = slots;
    }

    public String getUserName() {
        return this.userName;
    }

    public int getExp() {
        return this.exp;
    }

    public int getLevel() {
        return this.level;
    }
    public List<Sticker> getSlots() {return this.slots;}

    public String getProfileImahe() {
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

}
