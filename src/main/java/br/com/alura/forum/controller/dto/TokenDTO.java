package br.com.alura.forum.controller.dto;

public class TokenDTO {

    public String token;
    public String authMethod;

    public TokenDTO(String token, String authMethod) {
        this.token = token;
        this.authMethod =authMethod;
    }

    public String getToken() {
        return token;
    }

    public String getAuthMethod() {
        return authMethod;
    }
}
