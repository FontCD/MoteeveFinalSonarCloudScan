package logic.dao;

import logic.Connectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Calendar;
import java.util.Date;


public class TaskDAOJDBC {
    private final Connection conn = Connectivity.getConn(); 																																	//dalla classe connectivity prendo la connessione
    private PreparedStatement stmt = null;

    public int extractIdCurrent(int index)  {
        int id = 0;
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
        return id;
    }


    public String extractNameCurrent(int index)  {
        String name = "";
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
        return name;
    }

    public String extractScriptCurrent(int index)  {
        String script = "";
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
        return script;
    }

    public String extractColorCurrent(int index)  {
        String color = "";
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
        return color;
    }

    public boolean extractStatusCurrent(int index) {
        boolean status = false;
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
        return status;
    }

    public int extractRewardCurrent(int index) {
        int reward = 0;
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
        return reward;
    }


    public void setComplete(int taskId)  {
        try {
            stmt = conn.prepareStatement("UPDATE Task SET Status = 1 WHERE idTask =" + taskId, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);        //creo lo statement di update, il set a 1 identifica completato
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            Connectivity.close(stmt) ;
        }
    }

    public boolean isExpired(int idCurrent) {
        boolean isExpired = false;

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

        return isExpired;
    }


    public String extractName(int index)  {
        String tskName = "";
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
        return tskName;
    }

    public String extractScript(int index)  {
        String tskScript = "";
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
        return tskScript;
    }

    public String extractColor(int index)  {
        String tskColor = "";
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
        return tskColor;
    }

    public boolean extractStatus(int index) {
        boolean tskStatus = false;
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


    public void insertNewTask(int taskId,int index, String type){

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


    public boolean checkForATaskRequest()  {
        boolean result = false;
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

        return result;
    }


    public int getIdToChange() {
        int result = 0;
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
        return result;
    }

    public void insertTaskToChange(int id) {
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
