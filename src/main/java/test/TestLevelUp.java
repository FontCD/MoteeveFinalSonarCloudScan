package test;

import logic.Connectivity;
import logic.dao.CardDAOJDBC;
import logic.model.Card;
import logic.viewcard.ViewCardController;
import logic.viewcard.ViewCardUserBean;
import org.junit.Test;
import org.junit.Test;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TestLevelUp {

    @Test
    public void levelUpTest() throws SQLException, IOException {
        Connectivity.setConnection();

        ViewCardController controller1 = new ViewCardController();
        ViewCardUserBean cardBean = controller1.createCard();
        Card myCard = cardBean.getBean();
        CardDAOJDBC myDAO = new CardDAOJDBC();

        int currentLevel = myCard.getLevel();
        myCard.setLevel(1);
        myCard.addReward(1000);

        assertEquals(myCard.getLevel(), 2);

    }

}
