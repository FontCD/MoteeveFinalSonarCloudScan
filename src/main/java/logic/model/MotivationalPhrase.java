package logic.model;
import logic.dao.MotivationalPhraseDAOJDBC;

import java.sql.SQLException;

public class MotivationalPhrase { 					//Entity

    private int id;
    private String script;



    public MotivationalPhrase() {					//costruttore di default
    }

    public void setMotivationalPhrase (int id, String script) { 	//costruttore
        this.id = id;
        this.script = script;
    }

    public String getPhrase() { 					//getter
        return script;
    }

    public void setMotivationalPhrasebyId(int index) throws SQLException {
        MotivationalPhraseDAOJDBC dao = new MotivationalPhraseDAOJDBC();

        this.id = index;
        this.script = dao.extractPhrase(index);

    }
}
