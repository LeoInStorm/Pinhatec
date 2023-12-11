package com.example.pim.Db.Conexao;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    public static Connection conectar() throws ClassNotFoundException, SQLException {

        Connection conn = null;

            StrictMode.ThreadPolicy politica;
            politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);
        try {
           // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String ip = "192.168.15.101:139";
            String db = "Pinhatec_pim";
            String user = "sa";
            String senha = "1234";


            String connString = "jdbc:sqlserver://" + ip + ";databaseName=" + db + ";user=" + user + ";password=" + senha + ";";
            conn = DriverManager.getConnection(connString);
        }
        catch (SQLException e){
            e.getMessage();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




        return conn;
    }
}



