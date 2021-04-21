package br.com.alura.forum.controller.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class LoginForm {
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String senha;

    public LoginForm() {
    }

    public LoginForm(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Authentication converter() {
        return new UsernamePasswordAuthenticationToken(this.email, this.senha);
    }
}
