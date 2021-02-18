package dau.inter;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class ConnectDau {
    public static Connection connect ()throws Exception{
        String url = "jdbc:mysql://localhost:3306/admin";
        String userName = "shamkhal";
        String password = "Password123#@!";
        Connection c = DriverManager.getConnection(url,userName,password);
        return c;
    }
}
