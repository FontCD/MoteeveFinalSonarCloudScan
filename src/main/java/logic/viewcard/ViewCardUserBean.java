package logic.viewcard;

import logic.model.Card;

public class ViewCardUserBean {

    private Card viewCardUser;

    public void setBean (Card viewCardUser) {
        this.viewCardUser = viewCardUser;
    }

    public Card getBean(){
        return this.viewCardUser;
    }

}
