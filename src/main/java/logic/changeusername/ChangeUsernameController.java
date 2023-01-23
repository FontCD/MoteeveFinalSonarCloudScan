package logic.changeusername;


import logic.dao.CardDAOJDBC;
import logic.dao.ChangeUsernameDAOFS;
import logic.model.Card;


public class ChangeUsernameController {
    String persistence = "jdbc";

    public void setNewUsername(ChangeUsernameCardBean cardBean, ChangeUsernameUsernameBean usernameBean ) {

        String newUsername = usernameBean.getBean();
        Card card = cardBean.getBean();

        card.changeUsername(newUsername);

        if (persistence.equals("jdbc")) {

            CardDAOJDBC myDAO = new CardDAOJDBC();
            myDAO.updateUsername(newUsername);

        }
        else if (persistence.equals("filesystem")) {

            ChangeUsernameDAOFS myDAO = new ChangeUsernameDAOFS();
            myDAO.updateUsernameInFS(newUsername);
        }

    }

}
