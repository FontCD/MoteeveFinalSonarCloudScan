package logic.dao;

import logic.Connectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class StickerDAOJDBC {

    private final Connection conn = Connectivity.getConn();                                                                                                                            //dalla classe connectivity prendo la connessione
    private PreparedStatement stmt = null;

    public String extractName(int index) {
        String stkName = "";
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Name FROM Sticker WHERE idSticker =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();

            rs.first();
            stkName = rs.getString("Name");
            rs.close();
        } catch (SQLException e)  {
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return stkName;
    }

    public String extractStickerUrl(int index) {
        String stickerurl = "";
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT StickerURL FROM Sticker WHERE idSticker =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            stickerurl = rs.getString("StickerUrl");
            rs.close();
        } catch (SQLException e)  {
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return stickerurl;
    }

    public boolean extractStatus(int index)  {
        boolean stkStatus = false;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Status FROM Sticker WHERE idSticker =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            stkStatus = rs.getBoolean("Status");
            rs.close();
        } catch (SQLException e)  {
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);
        }
        return stkStatus;
    }

    public void setOwned(int index) {
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("UPDATE Sticker SET Status = 1 WHERE idSticker =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //creo lo statement di update, il set a 1 identifica sbloccato
            stmt.executeUpdate();
        } catch (SQLException e)  {
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);
        }
    }



}


