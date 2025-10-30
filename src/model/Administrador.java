package model;

import java.io.Serializable;

public class Administrador implements Serializable {
    private String nome;
    private String login;
    private String senha;
    
    public Administrador() {
    }
    
    public Administrador(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }
    
    @Override
    public String toString() {
        return "Administrador: " + nome + " (Login: " + login + ")";
    }
}