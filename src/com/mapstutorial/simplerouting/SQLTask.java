package com.mapstutorial.simplerouting;

import android.os.AsyncTask;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.sourceforge.jtds.jdbc.*;

public class SQLTask extends AsyncTask<String, Integer, Void> {
    public SQLTask(){

    }
    @Override
    protected void onPreExecute() {
        //TODO : Initialize shit
    }

    @Override
    protected Void doInBackground(String... args) {

        Connection connection = null;  // For making the connection
        Statement statement = null;    // For the SQL statement
        ResultSet resultSet = null;    // For the result set, if applicable

        String connectionString =
                "jdbc:jtds:sqlserver://wvuu7gl9t7.database.windows.net:1433;database=PairWalk;"
                        + "user=danklord@wvuu7gl9t7;password=Aylmao420;encrypt=true;"
                        + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        Log.e("ayy", "lmao");
        try {
            Log.e("dank", "memes1");
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            Log.e("dank", "memes2");
            connection = DriverManager.getConnection(connectionString);
            Log.e("dank", "memes3");

            String sqlString = "SELECT TOP 10 * FROM Person";

            statement = connection.createStatement();

            resultSet = statement.executeQuery(sqlString);
            Log.e("dank", "memes4");
            while (resultSet.next())
            {
                // Print out the row data
                Log.e("",
                        "Person with ID " +
                                resultSet.getString("Location") +
                                " has name " +
                                resultSet.getString("Name"));
            }

            Log.e("", "Processing complete.");

        } catch (Exception e) {
            Log.e("", e.toString());
        }
        return null;
    }

    @Override
    public void onProgressUpdate(Integer... progress){

    }

    @Override
    protected void onPostExecute(Void nothing) {
        Log.e("onPostExecute", "done");
    }
}