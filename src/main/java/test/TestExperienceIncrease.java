package test;

import logic.Connectivity;
import logic.dao.CardDAOJDBC;
import logic.model.Card;
import logic.viewcard.ViewCardController;
import logic.viewcard.ViewCardUserBean;
import org.junit.Test;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TestExperienceIncrease {

    //JUNIT TEST FEDERICO CANDELORI
    @Test
    public void testExperience() throws SQLException, IOException {
        Connectivity.setConnection();

        ViewCardController controller1 = new ViewCardController();
        ViewCardUserBean cardBean = controller1.createCard();
        Card myCard = cardBean.getBean();
        CardDAOJDBC myDAO = new CardDAOJDBC();

        int currentExp = myCard.getExp();
        myCard.addReward(100);
        myDAO.addExp(100);

        assertEquals(currentExp + 100, myDAO.extractExp());
    }

}
