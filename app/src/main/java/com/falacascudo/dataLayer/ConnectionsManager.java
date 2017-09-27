package com.falacascudo.dataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by carlo on 27/09/2017.
 */

public class ConnectionsManager {

    private static Connection LocalConnection =  null;
    private static Connection RemoteConnection =  null;
    private static String user = "";
    private static String password = "";
    private static String dbName = "";
    private static String dbUrl = "";


    private ConnectionsManager(){
        // TODO Auto-generated constructor stub

    }


    public static Connection getRemoteConnection() {

        try {
            if((RemoteConnection == null)||(RemoteConnection.isClosed())){
                try{

                    RemoteConnection = DriverManager.
                            getConnection("jdbc:mysql://"+dbUrl+"/"+dbName,user,password);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block

                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return RemoteConnection;
    }

    public static void closeRemoteConnection() throws SQLException{
        RemoteConnection.close();
    }

    public synchronized static Connection getLocalConnection(){

        try {
            if((LocalConnection == null)||(LocalConnection.isClosed())){
                try{

                    LocalConnection = DriverManager.
                            getConnection("jdbc:mysql://"+dbUrl+"/"+dbName,user,password);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block

                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return LocalConnection;
    }

    public static void closeLocalConnection() throws SQLException{
        LocalConnection.close();
    }



}
