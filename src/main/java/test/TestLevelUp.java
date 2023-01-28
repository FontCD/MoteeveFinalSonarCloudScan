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

    //JUNIT TEST BY FEDERICO CANDELORI
    //QUESTO TEST VERIFICA LA CORRETTEZZA DELL' AUMENTO DI LIVELLO QUANDO VENGONO RAGGIUNTI 1000 PUNTI ESPERIENZA

    @Test
    public void levelUpTest() throws SQLException, IOException {
        Connectivity.setConnection();

        //VIENE ISTANZIATO UN NUOVO CONTROLLER
        ViewCardController controller1 = new ViewCardController();
        //UN BEAN VIENE CARICATO CON LE INFORMAZIONI RELATIVE ALLA CARTA
        ViewCardUserBean cardBean = controller1.createCard();
        //LA CARD VIENE SETTATA IN MODO DA RIPROPORRE UN CASO GENERICO, LIVELLO 1, GUADAGNO DI 1500 EXP
        Card myCard = cardBean.getBean();
        myCard.setLevel(1);
        myCard.addReward(1500);

        //L' UTENTE FA LEVEL UP QUANDO RAGGIUNGE LA SOGLIA DI 1000 PUNTI ESPERIENZA
        //LA SUA ESPERIENZA VIENE RESETTATA E GLI VIENE ASSEGNATA LA DIFFERENZA COME ALTRI PUNTI
        //OVVIAMENTE IL SUO LIVELLO VIENE INCREMENTATO
        if (myCard.getExp() > 1000) {
            myCard.addReward(myCard.getExp()-1000);
            myCard.setLevel(myCard.getLevel()+1);
        }

        //CONTROLLO FINALE SE IL LIVELLO CORRENTE E' EFFETTIVAMENTE AUMENTATO
        assertEquals(myCard.getLevel(), 2);

    }

}
