package test;

import logic.Connectivity;
import logic.model.Card;
import logic.viewcard.ViewCardController;
import logic.viewcard.ViewCardUserBean;
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
        myCard.setLevel(1);
        myCard.addReward(1500);

        if (myCard.getExp() > 1000) {
            myCard.addReward(myCard.getExp()-1000);
            myCard.setLevel(myCard.getLevel()+1);
        }

        assertEquals(myCard.getLevel(), 2);

    }

}
