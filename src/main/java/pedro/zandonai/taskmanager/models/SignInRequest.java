package pedro.zandonai.taskmanager.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class SignInRequest {
    @NotBlank(message = "O nome de usuário não pode estar em branco.")
    private String username;

    @NotBlank(message = "A senha não pode estar em branco.")
    private String password;

    @NotBlank(message = "O email não pode estar em branco.")
    @Email
    private String email;


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
}
