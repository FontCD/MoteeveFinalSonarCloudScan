package logic.viewcard;

import logic.model.Card;

public class ViewCardUserBean {

    private Card user;

    public void setBean (Card user) {
        this.user = user;
    }

    public Card getBean(){
        return this.user;
    }

}
