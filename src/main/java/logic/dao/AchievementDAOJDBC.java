package logic.dao;

import logic.Connectivity;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AchievementDAOJDBC {
    private final Connection conn = Connectivity.getConn(); 																																	//dalla classe connectivity prendo la connessione
    PreparedStatement stmt = null;

    public String extractName(int index) {
        String achName = "";
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
        return achName;
    }

    public String extractScript(int index)  {
        String achScript = "";
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
        return achScript;
    }

    public String extractColor(int index)  {
        String achColor = "";
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
        return achColor;
    }

    public boolean extractStatus(int index) {
        boolean achStatus = false;
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
        return achStatus;
    }

    public int extractReward(int index) {
        int achReward = 0;
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
        return achReward;
    }


    public void setCompletable(int index)  {
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("UPDATE Achievement SET Status = 1 WHERE idAchievement =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //creo lo statement di update, il set a 1 identifica completato
            stmt.executeUpdate();
        } catch (SQLException e)  {
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);
        }
    }

    public void setComplete(int index) {
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
