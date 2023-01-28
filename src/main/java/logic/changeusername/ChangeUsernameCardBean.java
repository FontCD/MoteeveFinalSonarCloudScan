package logic.changeusername;

import logic.model.Card;

//BEAN CONTENENTE LE INFORMAZIONI SUL CAMBIO DI USERNAME SULLA CARD
public class ChangeUsernameCardBean {
    //ATTRIBUTI
    private Card changeUsernameCard;

    //METODI
    public void setBean(Card card){
        this.changeUsernameCard = card;
    }

    public Card getBean(){
        return this.changeUsernameCard;
    }

}
