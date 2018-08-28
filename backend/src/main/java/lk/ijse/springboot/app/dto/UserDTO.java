package lk.ijse.springboot.app.dto;


public class UserDTO {

    private String username;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
