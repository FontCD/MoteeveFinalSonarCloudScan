package logic;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class Connectivity {																	//classe che gestisce la connettività dell'applicazione al database
    //parametri di connessione
    private static String user = null;
    private static String pass = null;

    private static String dburl = null;
    private static Connection conn;


    public static void setConnection() throws IOException, SQLException {

            InputStream input = new FileInputStream("C:/Users/fonte/IdeaProjects/MoteeveFinalVersion/src/main/resources/properties.properties");
            Properties prop = new Properties();
            prop.load(input);

            user = prop.getProperty("db.user");
            pass = prop.getProperty("db.password");
            dburl = prop.getProperty("db.url");

            conn = DriverManager.getConnection(dburl,user, pass);

    }

    private Connectivity() {
        throw new IllegalStateException("Utility class");
    }

    public static Connection getConn() {													//metodo che serve ai DAO per prendere la connessione
        return conn;
    }

    public static void close(PreparedStatement stmt) {										//metodo che chiude lo statement
        try {
            if (stmt != null)
                stmt.close();
        } catch (SQLException se2) {
            se2.printStackTrace();
        }
    }



    public static void disconnect(Connection conn) {										//metodo da usare alla chiusura dell'applicazione e che chiude la connessione con il databse
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
