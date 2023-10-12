package ma.maisonSoftware.maisonSoftaware.model;

import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

//private String role;


    private String role;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "role_privilege", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "privilege_id"))
    private List<Privilege> privileges = new ArrayList<>();
    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
