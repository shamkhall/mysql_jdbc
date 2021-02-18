package dau.impl;

import bean.User;
import dau.inter.ConnectDau;
import dau.inter.UserDau;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDauImpl extends ConnectDau implements UserDau {

    @Override
    public List<User> getAll() throws Exception {

        List <User> result = new ArrayList<>();
        Connection c = connect();
        Statement stmt = c.createStatement();
        stmt.execute("SELECT * from Users");
        ResultSet rs = stmt.getResultSet();

        while (rs.next()){
            int Id = rs.getInt("Id");
            String Name = rs.getString("Name");
            String Password = rs.getString("Password");
            int Role = rs.getInt("Role");

            result.add(new User(Id, Name, Password, Role));
        }
        return result;
    }

    @Override
    public User getById(int id) throws Exception {
        User u = null;
        Connection c = connect();
        Statement stmt = c.createStatement();
        stmt.execute("SELECT * from Users where id="+id);
        ResultSet rs = stmt.getResultSet();

        while (rs.next()){
            int Id = rs.getInt("Id");
            String Name = rs.getString("Name");
            String Password = rs.getString("Password");
            int Role = rs.getInt("Role");

            u = new User(Id, Name, Password, Role);
        }
        return u;
    }

    @Override
    public boolean updateUser(User u) throws Exception {
        Connection c = connect();
        PreparedStatement stmt = c.prepareStatement("update Users set Name =?, Password=?, Role =? where id=?");
        stmt.setString(1, u.getName());
        stmt.setString(2, u.getPassword());
        stmt.setInt(3, u.getRole());
        stmt.setInt(4, u.getId());
        return stmt.execute();
    }

    @Override
    public boolean addUser(User u) throws Exception {
        Connection c = connect();
        PreparedStatement stmt = c.prepareStatement("Insert into Users(Name, Password, Role) Value (?. ?, ?)");
        stmt.setString(1, u.getName());
        stmt.setString(2,u.getPassword());
        stmt.setInt(3, u.getId());

        return stmt.execute();
    }

    @Override
    public boolean deleteUser(int id) throws Exception {
        Connection c = connect();
        Statement stmt = c.createStatement();
        return stmt.execute("DELETE from Users where id="+id);
    }


}
