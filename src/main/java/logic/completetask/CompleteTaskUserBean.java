package logic.completetask;

import logic.model.Card;

//BEAN RELATIVE AL COMPLETAMENTO DI UNA TASK DA PARTE DELL' UTENTE
public class CompleteTaskUserBean {

    //ATTRIBUTI
    private Card completeTaskCard;

    //METODI
    public void setBean(Card completeTaskCard){
        this.completeTaskCard = completeTaskCard;
    }

    public Card getBean(){
        return this.completeTaskCard;
    }
}
