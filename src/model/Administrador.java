package model;

/**
 * Classe que representa um Administrador do sistema
 */
public class Administrador {
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
    
    public void gerenciarSocios() {
        System.out.println("Gerenciando sócios...");
    }
    
    public void gerenciarCategorias() {
        System.out.println("Gerenciando categorias...");
    }
    
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }
    
    @Override
    public String toString() {
        return "Administrador: " + nome + " (Login: " + login + ")";
    }
}