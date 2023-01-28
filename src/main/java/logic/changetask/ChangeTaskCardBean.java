package logic.changetask;

import logic.model.Card;

public class ChangeTaskCardBean {
    private Card changeTaskCard;

    public void setBean(Card changeTaskCard) {
        this.changeTaskCard = changeTaskCard;
    }

    public Card getBean() {
        return this.changeTaskCard;
    }
}
