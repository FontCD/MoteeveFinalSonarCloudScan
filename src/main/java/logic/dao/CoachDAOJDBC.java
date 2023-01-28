package logic.dao;

import logic.Connectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//DAO RELATIVO ALLA GESTIONE SU DB DELLE INFORMAZIONI SUL COACH
public class CoachDAOJDBC {
    //STABILISCO LA CONNESSIONE COL DB
    private final Connection conn = Connectivity.getConn(); 																																	//dalla classe connectivity prendo la connessione
    PreparedStatement stmt = null;

    //METODO PER AGGIORNARE IL DATABASE CON LE FRASI INSERITE DAL COACH
    public void sendMotPhrRequest()  {
        //QUERY SQL
        try {
            stmt = conn.prepareStatement("UPDATE Coach SET richiestaMotPhr = 1 WHERE id = 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //creo lo statement di update, il set a 1 identifica completato
            stmt.executeUpdate();
        } catch (SQLException e)  {
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);
        }
    }

    //METODO PER INSERIRE UNA FRASE MOTIVAZIONALE NEL DB
    public void insertMotivationalPhrase(String motivationalPhrase)  {
        //QUERY SQL
        try {
            stmt = conn.prepareStatement("UPDATE Coach SET motivationalPhrase = ? WHERE id = 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            stmt.setString(1,motivationalPhrase);
            stmt.executeUpdate();                                                                               //creo lo statement di update, il set a 1 identifica completato
            stmt.close();

            stmt = conn.prepareStatement("UPDATE Coach SET prelievoMotPhr = 1 WHERE id = 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //creo lo statement di update, il set a 1 identifica completato
            stmt.executeUpdate();
        } catch (SQLException e)  {
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);
        }
    }

    //METODO PER RECUPERARE UNA FRASE MOTIVAZIONALE DAL DB
    public String takeMotivationalPhrase()  {
        String motivationalPhrase = "";
        //QUERY SQL
        try {
            stmt = conn.prepareStatement("SELECT motivationalPhrase FROM coach WHERE id = 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //creo lo statement di update, il set a 1 identifica completato
            ResultSet rs = stmt.executeQuery();
            rs.first();
            motivationalPhrase = rs.getString("motivationalPhrase");
            rs.close();

            stmt = conn.prepareStatement("UPDATE Coach SET richiestaMotPhr = 0 WHERE id = 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //creo lo statement di update, il set a 1 identifica completato
            stmt.executeUpdate();

            stmt = conn.prepareStatement("UPDATE Coach SET prelievoMotPhr = 0 WHERE id = 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //creo lo statement di update, il set a 1 identifica completato
            stmt.executeUpdate();
        } catch (SQLException e)  {
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);
        }
        //RITORNA UNA FRASE MOTIVAZIONALE
        return motivationalPhrase;
    }

    //CONTROLLO SE SONO PRESENTI FRASI MOTIVAZIONALI
    public boolean checkForAPhrase() {
        boolean phrasePresence = false;
        //QUERY SQL
        try {
            stmt = conn.prepareStatement("SELECT  prelievoMotPhr FROM coach WHERE id = 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //creo lo statement di update, il set a 1 identifica completato
            ResultSet rs = stmt.executeQuery();
            rs.first();
            phrasePresence = rs.getBoolean("prelievoMotPhr");
            rs.close();
        } catch (SQLException e)  {
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);
        }

        //RITORNO UN BOOLEANO
        return phrasePresence;
    }

    //CONTROLLO SE CI SONO RICHIESTE DI FRASI MOTIVAZIONALI
    public boolean checkRequest() {
        boolean requestPresence = false;
        //QUERY SQL
        try {
            stmt = conn.prepareStatement("SELECT  richiestaMotPhr FROM coach WHERE id = 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //creo lo statement di update, il set a 1 identifica completato
            ResultSet rs = stmt.executeQuery();
            rs.first();
            requestPresence = rs.getBoolean("richiestaMotPhr");
            rs.close();
        } catch (SQLException e)  {
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);
        }

        //RITORNO UN BOOLEANO
        return requestPresence;
    }
}
