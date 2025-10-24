package model;

import java.util.Objects;

/**
 * Classe que representa um Sócio do clube
 */
public class Socio {
    private String nome;
    private String cpf;
    private Categoria categoria;
    private String dataCadastro;
    
    public Socio() {
    }
    
    public Socio(String nome, String cpf, Categoria categoria, String dataCadastro) {
        this.nome = nome;
        this.cpf = cpf;
        this.categoria = categoria;
        this.dataCadastro = dataCadastro;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public String getDataCadastro() {
        return dataCadastro;
    }
    
    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    public void visualizarDados() {
        System.out.println("=== DADOS DO SÓCIO ===");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Categoria: " + categoria.getNomeCategoria());
        System.out.println("Data de Cadastro: " + dataCadastro);
    }
    
    public void atualizarDados(String novoNome, Categoria novaCategoria) {
        this.nome = novoNome;
        this.categoria = novaCategoria;
        System.out.println("Dados atualizados com sucesso!");
    }
    
    @Override
    public String toString() {
        return "Socio{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", categoria=" + (categoria != null ? categoria.getNomeCategoria() : "null") +
                ", dataCadastro='" + dataCadastro + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Socio)) return false;
        Socio socio = (Socio) o;
        return Objects.equals(cpf, socio.cpf);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}