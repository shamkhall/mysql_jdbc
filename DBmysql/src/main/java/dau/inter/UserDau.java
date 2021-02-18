package dau.inter;

import bean.User;

import java.util.List;

public interface UserDau {
    public List<User> getAll() throws Exception;
    public User getById(int id) throws Exception;
    public boolean updateUser(User u) throws Exception;
    public boolean addUser(User u) throws Exception;
    public boolean deleteUser(int id) throws Exception;

}
