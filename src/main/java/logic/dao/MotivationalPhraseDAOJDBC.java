package logic.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import logic.Connectivity;

public class MotivationalPhraseDAOJDBC {

    private final Connection conn = Connectivity.getConn(); 													//dalla classe connectivity prendo la connessione
    private PreparedStatement stmt = null;


    public String extractPhrase (int index) throws SQLException {

        String phrase ; 																			//parametro che ci servirà conservare la motivationalphrase

        try {
            stmt = conn.prepareStatement("SELECT Phrase FROM motivationalphrase WHERE idPhrase = " + index, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY ) ; //creo lo statement
            ResultSet rs = stmt.executeQuery() ; 																															//eseguo lo statement
            rs.first();																																						//punto la tupla ritornata dalla query

            phrase = rs.getString("phrase") ; 														//metto in phrase la striga contenuta nella colonna phrase

            rs.close(); 																			// chiudo il result set
        } finally {
            Connectivity.close(stmt) ; 																//dalla classe connectivity chiudo lo statement
        }

        return phrase;
    }
}
