package logic.dao;

import logic.Connectivity;
import logic.factory.StickerFactory;
import logic.model.Sticker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DAO RELATIVO ALLA GESTIONE DELL INFORMAZIONI SU DB DELLA CARD
public class CardDAOJDBC {

    //STABILISCO LA CONNESSIONE COL DB
    private final Connection conn = Connectivity.getConn();                                                                                                                                    //dalla classe connectivity prendo la connessione
    PreparedStatement stmt = null;

    //METODO PER ESTRARRE LO USERNAME DELL' UTENTE
    public String extractName() {
        String name = "";
        //QUERY SQL
        try {
            stmt = conn.prepareStatement("SELECT UserName FROM card", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();

            rs.first();
            name = rs.getString("UserName");
            rs.close();
        } catch (SQLException e)  {
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);
        }

        //RITORNA LO USERNAME
        return name;
    }

    //METODO PER ESTRARRE L' ESPERIENZA CORRENTE
    public int extractExp()  {
        int exp = 0;
        //QUERY SQL
        try {
            stmt = conn.prepareStatement("SELECT totalExp FROM card", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();

            rs.first();
            exp = rs.getInt("TotalExp");
            rs.close();
        } catch (SQLException e)  {
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);
        }
        //RITORNA L' ESPERIENZA CORRENTE
        return exp;
    }

    //METODO PER ESTRARRE DAL DB IL LIVELLO CORRENTE
    public int extractLevel() {
        int level = 0;
        //QUERY SQL
        try{
            stmt = conn.prepareStatement("SELECT level FROM card", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();

            rs.first();
            level = rs.getInt("level");
            rs.close();
        } catch (SQLException e)  {
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);
        }
        //RITORNA IL LIVELLO CORRENTE
        return level;
    }

    //METODO PER ESTRARRE DAL DB IL NUMERO DI CAMBI CORRENTI DELL' UTENTE
    public int extractChanges()  {
        int changes = 0;
        //QUERY SQL
        try {
            stmt = conn.prepareStatement("SELECT availableChanges FROM card", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();

            rs.first();
            changes = rs.getInt("availableChanges");
            rs.close();
        } catch (SQLException e)  {
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);
        }
        //RITORNA IL NUMERO CORRENTE DI CAMBIAMENTI
        return changes;
    }

    //METODO PER ESTRARRE DAL DB L' URL DELL' IMMAGINE DI PROFILO CORRENTE
    public String extractProfileImage() {
        String profileImage = "";
        //QUERY SQL
        try{
            stmt = conn.prepareStatement("SELECT profileImage FROM card", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();

            rs.first();
            profileImage = rs.getString("profileImage");
            rs.close();
        } catch (SQLException e)  {
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);
        }
        //VIENE RITORNATO L'URL
        return profileImage;
    }

    //MEOTODO PER RECUPERARE TUTTI GLI STICKER
    public List<Sticker> extractSlots() {
        //INFORMAZIONI NECESSARIE PER LA QUERY
        List<Sticker> slots = new ArrayList<>();
        StickerFactory factory = new StickerFactory();

        String forQueryIdSticker = "idSticker";
        String forQueryStickerUrl = "StickerUrl";
        String forQueryStatus = "Status";

        ResultSet rs;
        //QUERY SQL
        try{
            stmt = conn.prepareStatement("SELECT idSticker,Name,StickerURL,Status FROM card JOIN sticker WHERE slot1 = idSticker", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery() ;

            //------SLOT1--------

            rs.first();
            int idSticker1 = rs.getInt(forQueryIdSticker);
            String name1 = rs.getString("Name");
            String stickerUrl1 = rs.getString(forQueryStickerUrl);
            boolean status1 = rs.getBoolean(forQueryStatus);
            rs.close();

            Sticker stk1 = factory.createSticker(idSticker1, name1, stickerUrl1,status1);
            slots.add(stk1);

            //------SLOT2--------
            stmt = conn.prepareStatement("SELECT idSticker,Name,StickerURL,Status FROM card JOIN sticker WHERE slot2 = idSticker", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery() ;

            rs.first();
            int idSticker2 = rs.getInt(forQueryIdSticker);
            String name2 = rs.getString("Name");
            String stickerUrl2 = rs.getString(forQueryStickerUrl);
            boolean status2 = rs.getBoolean(forQueryStatus);
            rs.close();

            Sticker stk2 = factory.createSticker(idSticker2, name2, stickerUrl2,status2);
            slots.add(stk2);

            //---------SLOT3-------
            stmt = conn.prepareStatement("SELECT idSticker,Name,StickerURL,Status FROM card JOIN sticker WHERE slot3 = idSticker", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery() ;

            rs.first();
            int idSticker3 = rs.getInt(forQueryIdSticker);
            String name3 = rs.getString("Name");
            String stickerUrl3 = rs.getString(forQueryStickerUrl);
            boolean status3 = rs.getBoolean(forQueryStatus);
            rs.close();

            Sticker stk3 = factory.createSticker(idSticker3, name3, stickerUrl3,status3);
            slots.add(stk3);

            //-------SLOT4--------
            stmt = conn.prepareStatement("SELECT idSticker,Name,StickerURL,Status FROM card JOIN sticker WHERE slot4 = idSticker", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery() ;

            rs.first();
            int idSticker4 = rs.getInt(forQueryIdSticker);
            String name4 = rs.getString("Name");
            String stickerUrl4 = rs.getString(forQueryStickerUrl);
            boolean status4 = rs.getBoolean(forQueryStatus);
            rs.close();

            Sticker stk4 = factory.createSticker(idSticker4, name4, stickerUrl4,status4);
            slots.add(stk4);

            //-------SLOT5--------
            stmt = conn.prepareStatement("SELECT idSticker,Name,StickerURL,Status FROM card JOIN sticker WHERE slot5 = idSticker", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery() ;

            rs.first();
            int idSticker5 = rs.getInt(forQueryIdSticker);
            String name5 = rs.getString("Name");
            String stickerUrl5 = rs.getString(forQueryStickerUrl);
            boolean status5 = rs.getBoolean(forQueryStatus);
            rs.close();

            Sticker stk5 = factory.createSticker(idSticker5, name5, stickerUrl5,status5);
            slots.add(stk5);

            //-------SLOT6--------
            stmt = conn.prepareStatement("SELECT idSticker,Name,StickerURL,Status FROM card JOIN sticker WHERE slot6 = idSticker", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery() ;

            rs.first();
            int idSticker6 = rs.getInt(forQueryIdSticker);
            String name6 = rs.getString("Name");
            String stickerUrl6 = rs.getString(forQueryStickerUrl);
            boolean status6 = rs.getBoolean(forQueryStatus);
            rs.close();

            Sticker stk6 = factory.createSticker(idSticker6, name6, stickerUrl6,status6);
            slots.add(stk6);

            //-------SLOT7--------
            stmt = conn.prepareStatement("SELECT idSticker,Name,StickerURL,Status FROM card JOIN sticker WHERE slot7 = idSticker", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery() ;

            rs.first();
            int idSticker7 = rs.getInt(forQueryIdSticker);
            String name7 = rs.getString("Name");
            String stickerUrl7 = rs.getString(forQueryStickerUrl);
            boolean status7 = rs.getBoolean(forQueryStatus);
            rs.close();

            Sticker stk7 = factory.createSticker(idSticker7, name7, stickerUrl7,status7);
            slots.add(stk7);

            //-------SLOT8--------
            stmt = conn.prepareStatement("SELECT idSticker,Name,StickerURL,Status FROM card JOIN sticker WHERE slot8 = idSticker", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery() ;

            rs.first();
            int idSticker8 = rs.getInt(forQueryIdSticker);
            String name8 = rs.getString("Name");
            String stickerUrl8 = rs.getString(forQueryStickerUrl);
            boolean status8 = rs.getBoolean(forQueryStatus);
            rs.close();

            Sticker stk8 = factory.createSticker(idSticker8, name8, stickerUrl8,status8);
            slots.add(stk8);
        } catch (SQLException e)  {
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt);
        }

        //RITORNA LO STATUS DI TUTTI 8 GLI SLOT, SE ALL' INTERO DI ESSI ERANO STATI INSERITI DEGLI STICKER DALL' UTENTE
        return slots;
    }

    //METODO CHE DIMINUISCE IL NUMERO DI ELLE RICHIESTE DI CAMBI DI TASK RIMANENTI DA PARTE DELL' UTENTE
    public void decreaseChanges()  {
        //QUERY SQL
        try {
            stmt = conn.prepareStatement("SELECT availableChanges FROM card", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
            ResultSet rs = stmt.executeQuery() ;

            rs.first();
            int changes = rs.getInt("availableChanges");
            rs.close();

            if(changes != 0){
                changes = changes -1;
            }
            String forQuery = String.valueOf(changes);
            stmt = conn.prepareStatement("UPDATE card SET availableChanges =" + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
            stmt.executeUpdate();
        } catch (SQLException e)  {
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);
        }
    }

    //METODO PER AGGIORNARE L' ESPERIENZA DELL' UTENTE IN SEGUITO AD UN RICEVIMENTO DI RICOMPENSA PER TASK COMPLETATA
    public void addExp(int exp)  {

        int currentEXP;
        int newEXP;

        //QUERY SQL
        try {
            stmt = conn.prepareStatement("SELECT * FROM Card",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery() ;

            rs.first();

            currentEXP = rs.getInt("totalEXP");
            rs.close();

            newEXP = currentEXP + exp ;
            String forQuery = String.valueOf(newEXP) ;

            stmt = conn.prepareStatement("UPDATE Card SET totalEXP ="+forQuery);
            stmt.executeUpdate() ;
        } catch (SQLException e)  {
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt) ;
        }
    }

    //METODO PER AGGIORNARE IL NOME DELL' UTENTE SULLA CARD
    public void replaceName(String newName) throws SQLException {
        //QUERY SQL
        try {
            stmt = conn.prepareStatement("UPDATE `card` SET `Username` = '" + newName + "'", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.executeUpdate();
        } finally {
            Connectivity.close(stmt);
        }
    }
}
