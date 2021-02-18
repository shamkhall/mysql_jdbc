package bean;

public class User {
    public  int Id;
    public  String Name;
    public  String Password;
    public  int Role;


    public User() {
    }

    public User(int Id, String Name,String Password, int Role) {

        this.Id = Id;
        this.Name = Name;
        this.Password = Password;
        this.Role = Role;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int role) {
        Role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id= " + Id +
                ", Name= '" + Name + '\'' +
                ", Password= '" + Password + '\'' +
                ", Role= " + Role +
                '}';
    }
}
