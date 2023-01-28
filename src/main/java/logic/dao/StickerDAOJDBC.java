package logic.dao;

import logic.Connectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//DAO PER LA GESTIONE NELLA PERSISTENZA DELGI STICKER
public class StickerDAOJDBC {
    //STABILISCO LA CONNESSIONE COL DB
    private final Connection conn = Connectivity.getConn();                                                                                                                            //dalla classe connectivity prendo la connessione
    private PreparedStatement stmt = null;

    //METODO PER ESTRARRE IL NOME DELLO STICKER BASANDOSI SUL SUO ID
    public String extractName(int index) {
        String stkName = "";
        //QUERY SQL
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
        //RITORNO IL NOME DELLO STICKER CERCATO
        return stkName;
    }

    //METODO PER ESTRARRE L'URL DELLO STICKER BASANDOSI SUL SUO ID
    public String extractStickerUrl(int index) {
        String stickerurl = "";
        //QUERY SQL
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
        //RITORNA L'URL DELLO STICKER CERCATO
        return stickerurl;
    }

    //METODO PER CONTROLLARE SE UNO STICKER E' STATO SBLOCCATO DALL' UTENTE O MENO
    public boolean extractStatus(int index)  {
        boolean stkStatus = false;
        //QUERY SQL
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
        //RITORNA UN BOOLEANO COME RISPOSTA
        return stkStatus;
    }

    //METODO PER SETATRE NEL DB UNO STICKER COME SBLOCCATO, INSERENDONE IL RISPETTIVO ID
    public void setOwned(int index) {
        //QUERY SQL
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


