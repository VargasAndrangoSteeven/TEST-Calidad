package Model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
     private String bd = "sickdectbd";
    private String login="root";
    private String passw="root";
    private String url = "jdbc:mysql://localhost:3306/"+bd+"?autoReconnect=true&useSSL=false";
    java.sql.Connection objConex=null;

    public Conexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            objConex=DriverManager.getConnection("jdbc:mariadb://localhost/sickdectbd"
                +"?user=root&password=root");
            if(objConex!=null)
            {
                System.out.println("Conexion a BD SickDect APP OK");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public java.sql.Connection obtenerConexion()
    {
        return objConex;
    }

    }

/* Class.forName("org.mariadb.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mariadb://localhost/adoppet"
                +"?user=root&password=123456");*/


