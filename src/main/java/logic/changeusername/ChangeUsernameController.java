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

        //VIENE CREATO UN BEAN
        ChangeUsernameBean myBean = new ChangeUsernameBean();
        //LE INFORMAZIONI SUL VECCHIO NOME VENGONO COMUNQUE MEMORIZZATE PER RICORDARE ALLO USER IL VECCHIO USERNAME DOPO LA SOSTITUZIONE
        newUsernameBuffer = bean.getNewName();

        //LO USERNAME VIENE CAMBIATO
        Card card = cardBean.getBean();
        card.changeUsername(newUsernameBuffer);

        //SELEZIONE DEL METODO DI UTILIZZO DELLA PERSISTENZA
        if (persistence.equals("jdbc")) {
            //VIENE SETTATO IL NUOVO USERNAME NEL DATABASE
            CardDAOJDBC myDAO = new CardDAOJDBC();
            oldUsernameBuffer = myDAO.extractName();
            myDAO.replaceName(newUsernameBuffer);

        }
        else if (persistence.equals("filesystem")) {
            //VIENE SETTATO IL NUOVO USERNAME NEL FILE SYSTEM
            CardDAOFS myDAO = new CardDAOFS();
            oldUsernameBuffer = myDAO.extractNameFS();
            myDAO.replaceNameFS(newUsernameBuffer);

        }

        //IL BEAN VIENE CARICATO CON LE INFORMAZIONI RELATIVE AL CAMBIO DI USERNAME
        myBean.setOldName(oldUsernameBuffer);
        myBean.setNewName(newUsernameBuffer);

        return myBean;

    }

}
