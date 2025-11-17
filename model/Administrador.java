package model;

public class Administrador extends Pessoa {
    private String login;
    private String senha;
    
    public Administrador() {}
    
    public Administrador(String nome, String login, String senha) {
        super(nome, "000.000.000-00");
        this.login = login;
        this.senha = senha;
    }
    
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }
    
    @Override
    public void exibirInformacoes() {
        System.out.println("=== DADOS DO ADMINISTRADOR ===");
        System.out.println("Nome: " + nome);
        System.out.println("Login: " + login);
        System.out.println("CPF: " + cpf);  
    }
    
    @Override
    public String toString() {
        return "Administrador: " + nome + " (Login: " + login + ")";
    }
}