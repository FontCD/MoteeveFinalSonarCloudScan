package logic.factory;

import logic.model.Card;
import logic.model.Sticker;

import java.util.List;

public class CardFactory {
    public Card createUser(String userName, int exp, int lvl, int changes, String profileImage, List<Sticker> slots){
        return new Card(userName,exp,lvl,changes,profileImage,slots);
    }

}
