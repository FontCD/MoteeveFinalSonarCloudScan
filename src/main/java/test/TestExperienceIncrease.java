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

    //JUNIT TEST BY FEDERICO CANDELORI
    //QUESTO TEST VA A VERIFICARE CHE SIA AVVENUTO IL CORRETTO CONFERIMENTO DI PUNTI ESPERIENZA DA PARTE DELL' UTENTE
    // E CHE SIA AVVENUTO L' UPDATE DEI SUDDETTI PUNTI NEL DATABASE
    @Test
    public void testExperience() throws SQLException, IOException {
        //EFFETTUO LA CONNESSIONE AL DATABASE
        Connectivity.setConnection();

        //ISTANZIO IL CONTROLLER DELLA CARD (DENTRO CUI RISIEDE IL VALORE DI PUNTI ESPERIENZA ASSOCIATI ALL' UTENTE)
        ViewCardController controller1 = new ViewCardController();
        //UN BEAN VIENE CARICATO CON INFORMAZIONI RELATIVE ALL' EXP DELLA CARTA
        ViewCardUserBean cardBean = controller1.createCard();
        //ALTRE INFO NECESSARIE AL TEST VENGONO PRELEVATE DAL DATABASE
        Card myCard = cardBean.getBean();
        CardDAOJDBC myDAO = new CardDAOJDBC();

        //VIENE INCREMENTATO IL VALORE DELL' ESPERIENZA DELLA CARD, AGGIUNGENDO 100 PUNTI ALL' UTENTE
        int currentExp = myCard.getExp();
        myCard.addReward(100);
        myDAO.addExp(100);

        //VERIFICO LA CORRETTEZZA DEL TEST
        assertEquals((long)currentExp + 100, myDAO.extractExp());
    }

}
