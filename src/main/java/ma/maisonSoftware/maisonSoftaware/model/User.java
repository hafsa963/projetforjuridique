package ma.maisonSoftware.maisonSoftaware.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@Entity

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 5, message = "*Your username must have at least 5 characters")
    @NotEmpty(message = "*Please provide an user name")
    private String username;

    @Length(min = 3, message = "*Your name must have at least 5 characters")
    /*@NotEmpty(message = "*Please provide an user name")*/
    private String Nom;

    @Length(min = 3, message = "*Your prenom must have at least 5 characters")
   /* @NotEmpty(message = "*Please provide an user prenom")*/
    private String prenom;


    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;

    @Length(min = 5, message = "*Your confim password must have at least 5 characters")
    /*@NotEmpty(message = "*Please provide your Confirm password")*/
    private String ConfirmPassword;

    @Length(min = 5, message = "*Your poste must have at least 5 characters")
   /* @NotEmpty(message = "*Please provide your  poste")*/
    private String poste;

    @Length(min = 5, message = "*Your EmailPro must have at least 5 characters")
    /*@NotEmpty(message = "*Please provide your  EmailPro")*/
    private String EmailPro;

    @ManyToMany(cascade = CascadeType.ALL )
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    private boolean enabled ;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired ;
    private boolean accountNonLocked;

    public User(String username, String nom, String prenom, String password, String confirmPassword, String poste, String emailPro, List<Role> roles, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked) {

        this.username = username;
        Nom = nom;
        this.prenom = prenom;
        this.password = password;
        ConfirmPassword = confirmPassword;
        this.poste = poste;
        EmailPro = emailPro;
        this.roles = roles;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
    }

    /*public User(String username, String password, List<Role> roles, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
    }*/
}
