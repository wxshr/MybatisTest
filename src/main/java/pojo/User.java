package pojo;

public class User {
    private int id;
    private String username;
    private String email;
    private String phone;

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + ", phone=" + phone + "]";
    }

    // Getter 和 Setter 方法

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}