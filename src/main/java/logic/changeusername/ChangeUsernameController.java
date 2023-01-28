package logic.changeusername;


import logic.dao.CardDAOFS;
import logic.dao.CardDAOJDBC;
import logic.model.Card;

import java.sql.SQLException;

//CONTROLLER OF THE USE CASE [CHANGE USERNAME]
public class ChangeUsernameController {
    //BUFFERS THAT WILL CONTAIN THE OLD USERNAME AND THE NEW USERNAME
    String oldUsernameBuffer;
    String newUsernameBuffer;

    //STRING THAT DEFINES IF YOU WANT TO USE JDBC OF FILE SYSTEM PERSISTENCE TO STORE AND RETRIEVE YOUR USERNAME
    String persistence = "jdbc";

    //METHOD TO CHANGE THE USERNAME, RETURNS A BEAN CONTAINING ALL RELATIVE INFORMATION
    public ChangeUsernameBean setNewUsername(ChangeUsernameBean bean, ChangeUsernameCardBean cardBean) throws SQLException {

        ChangeUsernameBean myBean = new ChangeUsernameBean();
        newUsernameBuffer = bean.getNewName();

        Card card = cardBean.getBean();
        card.changeUsername(newUsernameBuffer);

        if (persistence.equals("jdbc")) {

            CardDAOJDBC myDAO = new CardDAOJDBC();
            oldUsernameBuffer = myDAO.extractName();
            myDAO.replaceName(newUsernameBuffer);

        }
        else if (persistence.equals("filesystem")) {

            CardDAOFS myDAO = new CardDAOFS();
            oldUsernameBuffer = myDAO.extractNameFS();
            myDAO.replaceNameFS(newUsernameBuffer);

        }

        myBean.setOldName(oldUsernameBuffer);
        myBean.setNewName(newUsernameBuffer);

        return myBean;

    }

}
