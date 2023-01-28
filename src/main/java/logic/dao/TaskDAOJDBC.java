package logic.dao;

import logic.Connectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Calendar;
import java.util.Date;

//DAO CHE SFRUTTA UND DATABASE VIA SQL PER LE TASK
public class TaskDAOJDBC {

    //STABILIMENTO DELLA CONNESSIONE
    private final Connection conn = Connectivity.getConn(); 																																	//dalla classe connectivity prendo la connessione
    private PreparedStatement stmt = null;

    //METODO PER ESTRARRE L' ID DI UNA TASK DAL DB
    public int extractIdCurrent(int index)  {
        int id = 0;
        //QUERY SQL
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Task FROM Task JOIN currenttasks WHERE Task = idTask AND idCurrentTasks = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            id = rs.getInt("Task");
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);                 //dalla classe connectivity chiudo lo statement
        }
        //RITORNA UN ID
        return id;
    }

    //METODO PER ESTRARRE LO USERNAME CORRENTE DELL' UTENTE
    public String extractNameCurrent(int index)  {
        String name = "";
        //QUERY SQL
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Name FROM Task JOIN currenttasks WHERE Task = idTask AND idCurrentTasks = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            name = rs.getString("Name");
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        // LO USERNAME CORRENTE
        return name;
    }

    //METODO PER ESTRARRE IL CONTENUTO EFFETTIVO DELLA TASK BASANDOSI SUL SUO ID
    public String extractScriptCurrent(int index)  {
        String script = "";
        //QUERY SQL
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Script FROM Task JOIN currenttasks WHERE Task = idTask AND idCurrentTasks = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            script = rs.getString("Script");
            rs.close();
        } catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        //RITORNA IL TESTO DELLA TASK
        return script;
    }

    //METODO PER ESTRARRE LA TIPOLOGIA DELLA TASK BASANDOSI SUL SUO ID
    public String extractColorCurrent(int index)  {
        String color = "";
        //QUERY SQL
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Color FROM Task JOIN currenttasks WHERE Task = idTask AND idCurrentTasks = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            color = rs.getString("Color");
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        //RITORNA IL COLORE DELLA TASK SOTTO FORMA DI STRINGA
        return color;
    }

    //METODO PER ESTRARRE LO STATUS DELLA TASK (SE E' EXPIRED O NO) BASANDOSI SUL SUO ID
    public boolean extractStatusCurrent(int index) {
        boolean status = false;
        //QUERY SQL
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Status FROM Task JOIN currenttasks WHERE Task = idTask AND idCurrentTasks = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            status = rs.getBoolean("Status");
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        //RITORNA LO STATUS COME BOOLEANO
        return status;
    }

    //METODO PER ESTRARRE LA RICOMPENSA DELLA TASK BASANDOSI SUL SUO ID
    public int extractRewardCurrent(int index) {
        int reward = 0;
        //QUERY SQL
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Reward FROM Task JOIN currenttasks WHERE Task = idTask AND idCurrentTasks = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            reward = rs.getInt("Reward");
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        //RITORNA I PUNTI ESPERIENZA COME RICOMPENSA
        return reward;
    }

    //METODO PER SETTARE UNA TASK COME COMPLETATA
    public void setComplete(int taskId)  {
        //QUERY SQL
        try {
            stmt = conn.prepareStatement("UPDATE Task SET Status = 1 WHERE idTask =" + taskId, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //creo lo statement di update, il set a 1 identifica completato
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt) ;
        }
    }

    //METODO PER CONTROLLARE SE UNA TASK HA TERMINATO IL SUO PERIODO DI VALIDITA'
    public boolean isExpired(int idCurrent) {
        boolean isExpired = false;

        //QUERY SQL
        try {
            stmt = conn.prepareStatement("SELECT scadenza FROM currentTasks WHERE idCurrentTasks =" + idCurrent, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();

            rs.first();
            Date scadenza = rs.getTimestamp("SCadenza");
            rs.close();

            Date now = new Date();
            if (scadenza.before(now)){
                isExpired = true;
            }
        }catch (SQLException e){
            e.printStackTrace();

        } finally {
            Connectivity.close(stmt);
        }
        //RITORNA LA VALIDITA' COME BOOLEANO
        return isExpired;
    }

    //METODO PER ESTRARRE IL NOME DELLA TASK BASANDOSI SUL SUO ID
    public String extractName(int index)  {
        String tskName = "";
        //QUERY SQL
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Name FROM Task WHERE idTask = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            tskName = rs.getString("Name");
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        //RITORNA IL NOME DELLA TASK
        return tskName;
    }

    //METODO PER ESTRARRE LO SCRIPT DELLA TASK BASANDOSI SUL SUO ID
    public String extractScript(int index)  {
        String tskScript = "";
        //QUERY SQL
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Script FROM Task WHERE idTask = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            tskScript = rs.getString("Script");
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        //RITORNA LO SCRIPT
        return tskScript;
    }

    //METODO PER RECUPERARE DAL DATABASE IL COLORE FINALE DI UNA TASK BASANDOSI SUL SUO ID
    public String extractColor(int index)  {
        String tskColor = "";
        //QUERY SQL
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Color FROM Task WHERE idTask = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            tskColor = rs.getString("Color");
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        //RITONA IL COLORE COME STRINGA
        return tskColor;
    }

    //METODO PER RECUPERARE DAL DATABASE LO STATUS DELLA TASK, OSSIA SE E' STATA COMPLETATA O NO
    public boolean extractStatus(int index) {
        boolean tskStatus = false;
        //QUERY SQL
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Status FROM Task WHERE idTask = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            tskStatus = rs.getBoolean("Status");
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        //RITORNA LO STATUS COME BOOLEANO
        return tskStatus;
    }

    public int extractReward(int index){
        int tskReward = 0;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Reward FROM Task WHERE idTask = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            tskReward = rs.getInt("Reward");
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return tskReward;
    }

    //METODO PER INSERIRE UNA NUOVA TASK
    public void insertNewTask(int taskId,int index, String type){

        //QUERY SQL
        try{
            String forQueryTask = String.valueOf(taskId) ;
            String forQueryId = String.valueOf(index) ;

            Date date=new Date();

            Calendar c = Calendar.getInstance();
            c.setTime(date);
            if (type.equals("Daily") ){
                c.add(Calendar.DATE,1);

            } else if (type.equals("Weekly")) {
                c.add(Calendar.DATE, 7);
            }
            Date newDate = c.getTime();

            java.sql.Timestamp sqlDate = new java.sql.Timestamp (newDate.getTime());

            stmt = conn.prepareStatement("Update currenttasks set task = " + forQueryTask + "  where idCurrenttasks = " + forQueryId, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY ) ; 		//creo lo statement di update, il set a 1 identifica completato
            stmt.executeUpdate() ;


            stmt = conn.prepareStatement("UPDATE currentTasks SET scadenza = ? WHERE idCurrentTasks = ?");
            stmt.setTimestamp(1,sqlDate);
            stmt.setString(2,forQueryId);
            stmt.executeUpdate() ;

            stmt = conn.prepareStatement("Update coach set richiestaTask = 0 where id = 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
            stmt.executeUpdate() ;

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt) ;
        }
    }

    //METODO PER IL COACH, CONTROLLA SE SONO STATE EFFETTUARE RICHIESTE DI CAMBIO DI TASK DA PARTE DI QUALCHE UTENTE
    public boolean checkForATaskRequest()  {
        boolean result = false;
        //QUERY SQL
        try {
            stmt = conn.prepareStatement("SELECT richiestaTask FROM coach WHERE id = 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //creo lo statement di update, il set a 1 identifica completato
            ResultSet rs = stmt.executeQuery();
            rs.first();
            result = rs.getBoolean("richiestaTask");
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);
        }
        //RITORNA UN BOOLEANO COME RISULTATO
        return result;
    }

    //METODO PER IL COACH, PER STABILIRE L' ID DELLA TASK DA AGGIORNARE NEL DATABASE
    public int getIdToChange() {
        int result = 0;
        //QUERY SQL
        try {
            stmt = conn.prepareStatement("SELECT idToChange FROM coach WHERE id = 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //creo lo statement di update, il set a 1 identifica completato
            ResultSet rs = stmt.executeQuery();
            rs.first();
            result = rs.getInt("idToChange");
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);
        }
        //RITORNA UN INTERO COME RISULTATO
        return result;
    }

    //METODO PER INSERIRE L' ID DELLA TASK CAMBIATA NEL DATABASE
    public void insertTaskToChange(int id) {
        //QUERY SQL
        try {
            stmt = conn.prepareStatement("Update coach set idToChange = " + id, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
            stmt.executeUpdate() ;

            stmt = conn.prepareStatement("Update coach set richiestaTask = 1 where id = 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
            stmt.executeUpdate() ;

        }catch (SQLException e){
            e.printStackTrace();
        } finally {
            Connectivity.close(stmt);
        }
    }
}
