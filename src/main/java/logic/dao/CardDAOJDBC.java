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

public class CardDAOJDBC {

    private final Connection conn = Connectivity.getConn();                                                                                                                                    //dalla classe connectivity prendo la connessione
    PreparedStatement stmt = null;

    public String extractName() throws Exception {
        String name;

        try {
            stmt = conn.prepareStatement("SELECT UserName FROM card", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();

            rs.first();
            name = rs.getString("UserName");
            rs.close();
        } finally {
            Connectivity.close(stmt);
        }

        return name;
    }

    public int extractExp() throws Exception {
        int exp;

        try {
            stmt = conn.prepareStatement("SELECT totalExp FROM card", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();

            rs.first();
            exp = rs.getInt("TotalExp");
            rs.close();
        } finally {
            Connectivity.close(stmt);
        }

        return exp;
    }

    public int extractLevel() throws Exception {
        int level;

        try{
            stmt = conn.prepareStatement("SELECT level FROM card", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();

            rs.first();
            level = rs.getInt("level");
            rs.close();

        } finally {
            Connectivity.close(stmt);
        }
        return level;
    }

    public int extractChanges() throws Exception {
        int changes;
        try {
            stmt = conn.prepareStatement("SELECT availableChanges FROM card", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();

            rs.first();
            changes = rs.getInt("availableChanges");
            rs.close();
        } finally {
            Connectivity.close(stmt);
        }

        return changes;
    }

    public String extractProfileImage() throws Exception {
        String profileImage;

        try{
            stmt = conn.prepareStatement("SELECT profileImage FROM card", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();

            rs.first();
            profileImage = rs.getString("profileImage");
            rs.close();
        } finally {
            Connectivity.close(stmt);
        }
            return profileImage;
        }

    public List<Sticker> extractSlots() throws Exception{
        List<Sticker> slots = new ArrayList<>();

        StickerFactory factory = new StickerFactory();
        Sticker stk;

        int idSticker;
        String name;
        String stickerUrl;
        boolean status;

        ResultSet rs;

        try{
            stmt = conn.prepareStatement("SELECT idSticker,Name,StickerURL,Status FROM card JOIN sticker WHERE slot1 = idSticker", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery() ;

            //------SLOT1--------
            rs.first();
            idSticker = rs.getInt("idSticker");
            name = rs.getString("Name");
            stickerUrl = rs.getString("StickerUrl");
            status = rs.getBoolean("Status");
            rs.close();

            stk = factory.createSticker(idSticker, name, stickerUrl,status);
            slots.add(stk);

            //------SLOT2--------
            stmt = conn.prepareStatement("SELECT idSticker,Name,StickerURL,Status FROM card JOIN sticker WHERE slot2 = idSticker", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery() ;

            rs.first();
            idSticker = rs.getInt("idSticker");
            name = rs.getString("Name");
            stickerUrl = rs.getString("StickerUrl");
            status = rs.getBoolean("Status");
            rs.close();

            stk = factory.createSticker(idSticker, name, stickerUrl,status);
            slots.add(stk);

            //---------SLOT3-------
            stmt = conn.prepareStatement("SELECT idSticker,Name,StickerURL,Status FROM card JOIN sticker WHERE slot3 = idSticker", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery() ;

            rs.first();
            idSticker = rs.getInt("idSticker");
            name = rs.getString("Name");
            stickerUrl = rs.getString("StickerUrl");
            status = rs.getBoolean("Status");
            rs.close();

            stk = factory.createSticker(idSticker, name, stickerUrl,status);
            slots.add(stk);

            //-------SLOT4--------
            stmt = conn.prepareStatement("SELECT idSticker,Name,StickerURL,Status FROM card JOIN sticker WHERE slot4 = idSticker", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery() ;

            rs.first();
            idSticker = rs.getInt("idSticker");
            name = rs.getString("Name");
            stickerUrl = rs.getString("StickerUrl");
            status = rs.getBoolean("Status");
            rs.close();

            stk = factory.createSticker(idSticker, name, stickerUrl,status);
            slots.add(stk);

            //-------SLOT5--------
            stmt = conn.prepareStatement("SELECT idSticker,Name,StickerURL,Status FROM card JOIN sticker WHERE slot5 = idSticker", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery() ;

            rs.first();
            idSticker = rs.getInt("idSticker");
            name = rs.getString("Name");
            stickerUrl = rs.getString("StickerUrl");
            status = rs.getBoolean("Status");
            rs.close();

            stk = factory.createSticker(idSticker, name, stickerUrl,status);
            slots.add(stk);

            //-------SLOT6--------
            stmt = conn.prepareStatement("SELECT idSticker,Name,StickerURL,Status FROM card JOIN sticker WHERE slot6 = idSticker", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery() ;

            rs.first();
            idSticker = rs.getInt("idSticker");
            name = rs.getString("Name");
            stickerUrl = rs.getString("StickerUrl");
            status = rs.getBoolean("Status");
            rs.close();

            stk = factory.createSticker(idSticker, name, stickerUrl,status);
            slots.add(stk);

            //-------SLOT7--------
            stmt = conn.prepareStatement("SELECT idSticker,Name,StickerURL,Status FROM card JOIN sticker WHERE slot7 = idSticker", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery() ;

            rs.first();
            idSticker = rs.getInt("idSticker");
            name = rs.getString("Name");
            stickerUrl = rs.getString("StickerUrl");
            status = rs.getBoolean("Status");
            rs.close();

            stk = factory.createSticker(idSticker, name, stickerUrl,status);
            slots.add(stk);

            //-------SLOT8--------
            stmt = conn.prepareStatement("SELECT idSticker,Name,StickerURL,Status FROM card JOIN sticker WHERE slot8 = idSticker", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery() ;

            rs.first();
            idSticker = rs.getInt("idSticker");
            name = rs.getString("Name");
            stickerUrl = rs.getString("StickerUrl");
            status = rs.getBoolean("Status");
            rs.close();

            stk = factory.createSticker(idSticker, name, stickerUrl,status);
            slots.add(stk);

        }finally {
            Connectivity.close(stmt);
        }

        return slots;
    }


    public void decreaseChanges() throws SQLException {

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

        } finally {
            Connectivity.close(stmt);
        }
    }

    public void addExp(int exp) throws SQLException {

        int currentEXP;
        int newEXP;

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

        }finally {
            Connectivity.close(stmt) ;
        }
    }

}
