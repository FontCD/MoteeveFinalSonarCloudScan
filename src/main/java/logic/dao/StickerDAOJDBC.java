package logic.dao;

import logic.Connectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StickerDAOJDBC {

    private final Connection conn = Connectivity.getConn();                                                                                                                            //dalla classe connectivity prendo la connessione
    private PreparedStatement stmt = null;

    public String extractName(int index) throws SQLException {
        String name;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Name FROM Sticker WHERE idSticker =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la queryint id = rs.getInt("idSticker");

            rs.first();
            name = rs.getString("Name");
            rs.close();

        } finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return name;
    }

    public String extractStickerUrl(int index) throws SQLException {
        String stickerurl;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT StickerURL FROM Sticker WHERE idSticker =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            stickerurl = rs.getString("StickerUrl");
            rs.close();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return stickerurl;
    }

    public boolean extractStatus(int index) throws SQLException {
        boolean status;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Status FROM Sticker WHERE idSticker =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            status = rs.getBoolean("Status");
            rs.close();
        } finally {
            Connectivity.close(stmt);
        }
        return status;
    }

    public void setOwned(int index) throws SQLException {
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("UPDATE Sticker SET Status = 1 WHERE idSticker =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //creo lo statement di update, il set a 1 identifica sbloccato
            stmt.executeUpdate();
        } finally {
            Connectivity.close(stmt);
        }
    }



}


