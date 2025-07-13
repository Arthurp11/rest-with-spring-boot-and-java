package Arthurp11.com.github.data.dto;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String password;
    private String name;
    private String email;
    private String phone;

    public UserDTO() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UserDTO user)) return false;
        return getId() == user.getId() && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getName(), user.getName()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPhone(), user.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPassword(), getName(), getEmail(), getPhone());
    }
}
