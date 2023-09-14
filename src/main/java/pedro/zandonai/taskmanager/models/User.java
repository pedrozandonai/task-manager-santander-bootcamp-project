package pedro.zandonai.taskmanager.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome não pode estar em branco.")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres.")
    private String username;
    @NotBlank(message = "O endereço de email não pode estar em branco.")
    @Email(message = "O endereço de email deve ser válido.")
    private String emailAddress;

    @NotBlank(message = "A senha não pode estar em branco.")
    @Size(min = 5, max = 50, message = "A senha deve ter entre 5 a 50 caracteres.")
    private String password;

    public User(Long id, String nome, String emailAddress) {
        this.id = id;
        this.username = nome;
        this.emailAddress = emailAddress;
    }

    public User(String nome, String password) {
        this.username = nome;
        this.password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
