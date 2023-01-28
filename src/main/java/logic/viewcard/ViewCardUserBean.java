package logic.viewcard;

import logic.model.Card;

//BEAN CONTENENTE LE INFORMAZIONI SULLA CARD
public class ViewCardUserBean {

    //ATTRIBUTI
    private Card viewCardUser;

    //METODI

    public void setBean (Card viewCardUser) {
        this.viewCardUser = viewCardUser;
    }

    public Card getBean(){
        return this.viewCardUser;
    }

}
