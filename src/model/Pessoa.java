package model;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {
    protected String nome;
    protected String cpf;
    
    public Pessoa() {}
    
    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    
    public abstract void exibirDados();
}