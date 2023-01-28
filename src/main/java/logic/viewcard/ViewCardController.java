package logic.viewcard;

import logic.dao.CardDAOJDBC;
import logic.factory.CardFactory;
import logic.model.Card;
import logic.model.Sticker;

import java.util.List;

public class ViewCardController {

    public ViewCardUserBean createCard(){
        CardDAOJDBC dao = new CardDAOJDBC();
        CardFactory factory = new CardFactory();

        String name = dao.extractName();
        int exp = dao.extractExp();
        int lvl = dao.extractLevel();
        int changes = dao.extractChanges();
        String profileImage = dao.extractProfileImage();
        List<Sticker> slots = dao.extractSlots();

        Card user = factory.createUser(name,exp,lvl,changes,profileImage,slots);

        ViewCardUserBean bean = new ViewCardUserBean();
        bean.setBean(user);

        return bean ;
    }

}
