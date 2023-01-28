package logic.changetask;

import logic.model.Card;

//BEAN CONTENENTE INFO SUI CAMBI RIMANENTI PER LE TASK SULLA CARTA
public class ChangeTaskCardBean {

    //ATTRIBUTI
    private Card changeTaskCard;

    //METODI
    public void setBean(Card changeTaskCard) {
        this.changeTaskCard = changeTaskCard;
    }

    public Card getBean() {
        return this.changeTaskCard;
    }
}
