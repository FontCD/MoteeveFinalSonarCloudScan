package logic.completetask;

import logic.model.Card;

public class CompleteTaskUserBean {

    private Card completeTaskCard;

    public void setBean(Card completeTaskCard){
        this.completeTaskCard = completeTaskCard;
    }

    public Card getBean(){
        return this.completeTaskCard;
    }
}
