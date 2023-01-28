package logic.dao;

import logic.Connectivity;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//DAO RELATIVO ALLA GESTIONE SU PERSISTENZA DEGLI ACHIEVEMENT
public class AchievementDAOJDBC {

    //STABILISCO LA CONNESSIONE
    private final Connection conn = Connectivity.getConn(); 																																	//dalla classe connectivity prendo la connessione
    PreparedStatement stmt = null;

    //METODO PER ESTRARRE IL NOME DELL' ACHIEVEMENT DAL DABATABASE
    public String extractName(int index) {
        String achName = "";
        //QUERY SQL
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Name FROM Achievement WHERE idAchievement =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            achName = rs.getString("Name");
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        //RITORNA IL NOME DELLA STRINGA
        return achName;
    }

    //METODO PER ESTRARRE DAL DB IL CONTENUTO DELL' ACHIEVEMENT
    public String extractScript(int index)  {
        String achScript = "";
        //QUERY SQL
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Script FROM Achievement WHERE idAchievement =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            achScript = rs.getString("Script");
            rs.close();
        } catch (SQLException e)  {
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        //RITORNA LO SCRIPT DELL' ACHIEVEMENT
        return achScript;
    }

    //METODO PER ESTARRRE DAL DB LA TIPOLOGIA DELL' ACHIEVEMENT
    public String extractColor(int index)  {
        String achColor = "";
        //QUERY SQL
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Color FROM Achievement WHERE idAchievement =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            achColor = rs.getString("Color");
            rs.close();             //eseguo la query
        } catch (SQLException e)  {
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }

        //RITORNA IL COLORE SOTTO FORMA DI STRINGA
        return achColor;
    }

    //METODO PER ESTRARRE DAL DATABASE L'INFORMAZIONE SE UN ACHIEVEMENT E' GIA' STATO COMPLETATO O NO
    public boolean extractStatus(int index) {
        boolean achStatus = false;
        //QUESY SQL
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Status FROM Achievement WHERE idAchievement =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            achStatus = rs.getBoolean("Status");
            rs.close();
        } catch (SQLException e)  {
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        //RITORNA LO STATUS DELL' ACHIEVEMENT
        return achStatus;
    }

    //METODO PER ESTRARRE L' ID DELLO STICKER DATO COME RICOMPENSA PER IL COMPLETAMENTO DELL' ACHIEVEMENT CORRISPONDENTE ALLO STESSO ID
    public int extractReward(int index) {
        int achReward = 0;
        //QUERY SQL
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Reward FROM Achievement WHERE idAchievement =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            achReward = rs.getInt("Reward");
            rs.close();
        } catch (SQLException e)  {
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        //RITORNA L' ID DELLO STICKER COME RICOMPENSA
        return achReward;
    }

    //METODO PER SETTARE UN ACHIEVEMENT COME COMPLETATO
    public void setComplete(int index) {
        //QUERY SQL
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("UPDATE Achievement SET script = 'Completato' WHERE idAchievement =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //creo lo statement di update, il set a 1 identifica completato
            stmt.executeUpdate();
        } catch (SQLException e)  {
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);
        }
    }

}
