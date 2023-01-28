package logic.changeusername;

import logic.model.Card;

public class ChangeUsernameCardBean {
    private Card changeUsernameCard;

    public void setBean(Card card){
        this.changeUsernameCard = card;
    }

    public Card getBean(){
        return this.changeUsernameCard;
    }

}
