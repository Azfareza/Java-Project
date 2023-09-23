// membuat class user
public class user {
    // atribut user
    private String name;
    private String username;
    private String password;
    
    // constructor user
    public user(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    //method getter utk mengambil data atribut name 
    public String getName() {
        return name;
    }

    //method setter utk mengubah data atribut name 
    public void setName(String name) {
        this.name = name;
    }

    //method getter utk mengambil data atribut username
    public String getUsername() {
        return username;
    }

    //method setter utk mengubah data atribut username
    public void setUsername(String username) {
        this.username = username;
    }

    //method getter utk mengambil data atribut password
    public String getPassword() {
        return password;
    }

    //method setter utk mengubah data atribut password
    public void setPassword(String password) {
        this.password = password;
    }
}
