package bank.management.system.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    Connection c;
    public Statement s ;
    public Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","root");
            s = c.createStatement();

        }catch (Exception e){

        }
    }
}
