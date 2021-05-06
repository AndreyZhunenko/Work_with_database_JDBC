package com.example.clients_of_kars_on_server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws
            ClassNotFoundException,
            SQLException{
        /*String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName + "?verifyServerCertificate=false"+
                "&useSSL=false"+"&requireSSL=false"+"&useLegacyDatetimeCode=false"+
                "&amp"+"&serverTimezone=UTC";*/
        String connectionString = "jdbc:mysql://localhost:3306/start_work_with_db_in_android?" +
                "autoReconnect=true&useSSL=false";

        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);

        return dbConnection;
    }

    public String signUpUser(String Name, String Sername){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USER_NAME + "," + Const.USER_SERNAME + ")" +
                "VALUES(?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, Name);
            prSt.setString(2, Sername);

            prSt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return insert;
    }

}

