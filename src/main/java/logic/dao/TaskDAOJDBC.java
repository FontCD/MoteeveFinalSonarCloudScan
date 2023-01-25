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

    public int extractIdCurrent(int index) throws SQLException {

        try {
            stmt = conn.prepareStatement("SELECT Task FROM currenttasks WHERE idCurrentTasks = " + index, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();
            rs.first();
            int code = rs.getInt("Task");
            rs.close();

        } finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }

        int id;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Task FROM Task JOIN currenttasks WHERE Task = idTask AND idCurrentTasks = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            id = rs.getInt("Task");
            rs.close();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return id;
    }


    public String extractNameCurrent(int index) throws SQLException {
        String name;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Name FROM Task JOIN currenttasks WHERE Task = idTask AND idCurrentTasks = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            name = rs.getString("Name");
            rs.close();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return name;
    }

    public String extractScriptCurrent(int index) throws SQLException {
        String script;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Script FROM Task JOIN currenttasks WHERE Task = idTask AND idCurrentTasks = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            script = rs.getString("Script");
            rs.close();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return script;
    }

    public String extractColorCurrent(int index) throws SQLException {
        String color;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Color FROM Task JOIN currenttasks WHERE Task = idTask AND idCurrentTasks = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            color = rs.getString("Color");
            rs.close();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return color;
    }

    public boolean extractStatusCurrent(int index) throws SQLException {
        boolean status;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Status FROM Task JOIN currenttasks WHERE Task = idTask AND idCurrentTasks = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            status = rs.getBoolean("Status");
            rs.close();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return status;
    }

    public int extractRewardCurrent(int index) throws SQLException {
        int reward;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Reward FROM Task JOIN currenttasks WHERE Task = idTask AND idCurrentTasks = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            reward = rs.getInt("Reward");
            rs.close();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return reward;
    }


    public void setComplete(int idCurrent, int taskId) throws Exception {
        try{
            stmt = conn.prepareStatement("UPDATE Task SET Status = 1 WHERE idTask =" + taskId, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY ) ; 		//creo lo statement di update, il set a 1 identifica completato
            stmt.executeUpdate() ;

        }finally {
            Connectivity.close(stmt) ;
        }
    }

    public boolean isExpired(int idCurrent) throws Exception {
        boolean isExpired = false;

        try {
            stmt = conn.prepareStatement("SELECT scadenza FROM currentTasks WHERE idCurrentTasks =" + idCurrent, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery();

            rs.first();
            Date scadenza = rs.getTimestamp("Scadenza");
            rs.close();

            Date now = new Date();
            if (scadenza.before(now)){
                isExpired = true;
            }

        } finally {
            Connectivity.close(stmt);
        }

        return isExpired;
    }



    public int extractId(int index) throws SQLException {
        int id;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Task FROM Task JOIN currenttasks WHERE Task = idTask AND idCurrentTasks = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            id = rs.getInt("Task");
            rs.close();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return id;
    }


    public String extractName(int index) throws SQLException {
        String name;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Name FROM Task WHERE idTask = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            name = rs.getString("Name");
            rs.close();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return name;
    }

    public String extractScript(int index) throws SQLException {
        String script;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Script FROM Task WHERE idTask = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            script = rs.getString("Script");
            rs.close();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return script;
    }

    public String extractColor(int index) throws SQLException {
        String color;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Color FROM Task WHERE idTask = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            color = rs.getString("Color");
            rs.close();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return color;
    }

    public boolean extractStatus(int index) throws SQLException {
        boolean status;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Status FROM Task WHERE idTask = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            status = rs.getBoolean("Status");
            rs.close();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return status;
    }

    public int extractReward(int index) throws SQLException {
        int reward;
        try {
            String forQuery = String.valueOf(index);
            stmt = conn.prepareStatement("SELECT Reward FROM Task WHERE idTask = " + forQuery, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);    //creo uno statement che porta un result set
            ResultSet rs = stmt.executeQuery();                                                                                                                            //eseguo la query

            rs.first();
            reward = rs.getInt("Reward");
            rs.close();
        }finally {
            Connectivity.close(stmt);                                                                                                                                        //dalla classe connectivity chiudo lo statement
        }
        return reward;
    }


    public void insertNewTask(int taskId,int index, String type)throws SQLException{
        try{
            String forQueryTask = String.valueOf(taskId) ;
            String forQueryId = String.valueOf(index) ;

            Date date=new Date();

            Calendar c = Calendar.getInstance();
            c.setTime(date);
            if (type.equals("Daily") ){
                c.add(Calendar.DATE,1);

            } else if (type.equals("Weekly")){
                c.add(Calendar.DATE,7);
            } else {
                System.out.println("Invalid Type"); //sostituire con eccezione
            }
            Date newDate = c.getTime();

            java.sql.Timestamp sqlDate = new java.sql.Timestamp (newDate.getTime());

            stmt = conn.prepareStatement("Update currenttasks set task = " + forQueryTask + "  where idCurrenttasks = " + forQueryId, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY ) ; 		//creo lo statement di update, il set a 1 identifica completato
            stmt.executeUpdate() ;


            stmt = conn.prepareStatement("UPDATE currentTasks SET scadenza = ? WHERE idCurrentTasks = ?");
            stmt.setTimestamp(1,sqlDate);
            stmt.setString(2,forQueryId);
            stmt.executeUpdate() ;

        }finally {
            Connectivity.close(stmt) ;
        }
    }


}
