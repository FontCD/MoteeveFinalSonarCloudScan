package logic.dao;

import logic.Connectivity;
import logic.factory.BaseObject;
import logic.factory.ObjectFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AchievementDAOJDBC {
    private final Connection conn = Connectivity.getConn(); 																																	//dalla classe connectivity prendo la connessione
    PreparedStatement stmt = null;

    public String extractName(int index) throws SQLException {
        String name;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Name FROM Achievement WHERE idAchievement =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            name = rs.getString("Name");
            rs.close();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return name;
    }

    public String extractScript(int index) throws SQLException {
        String script;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Script FROM Achievement WHERE idAchievement =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            script = rs.getString("Script");
            rs.close();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return script;
    }

    public String extractColor(int index) throws SQLException {
        String color;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Color FROM Achievement WHERE idAchievement =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            color = rs.getString("Color");
            rs.close();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return color;
    }

    public boolean extractStatus(int index) throws SQLException {
        boolean status;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Status FROM Achievement WHERE idAchievement =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            status = rs.getBoolean("Status");
            rs.close();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return status;
    }

    public int extractReward(int index) throws SQLException {
        int reward;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Reward FROM Achievement WHERE idAchievement =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            reward = rs.getInt("Reward");
            rs.close();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return reward;
    }


    public void setCompletable(int index) throws Exception {
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("UPDATE Achievement SET Status = 1 WHERE idAchievement =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //creo lo statement di update, il set a 1 identifica completato
            stmt.executeUpdate();
        } finally {
            Connectivity.close(stmt);
        }
    }

    public void setComplete(int index) throws SQLException {
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("UPDATE Achievement SET script = 'Completato' WHERE idAchievement =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //creo lo statement di update, il set a 1 identifica completato
            stmt.executeUpdate();
        } finally {
            Connectivity.close(stmt);
        }
    }

}
