public class User{
    // properties
    private String username;
    private String password;
    private String email;
    private boolean admin;
    // constructor methods
    public User(String username, String password, String email, boolean admin){
        this.username= username;
        this.password= password;
        this.email= email;
        this.admin= admin;
    }
    public User(String username, String password, String email){
        this.username= username;
        this.password= password;
        this.email= email;
        this.admin= false;
    }
    // setter methods
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    // getter method
    public boolean isAdmin() {
        return admin;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
}