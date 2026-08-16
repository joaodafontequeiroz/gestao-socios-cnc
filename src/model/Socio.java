package model;

import java.io.Serializable;

public class Socio extends Pessoa implements Serializable {
    private Categoria categoria;
    private String dataCadastro;
    
    public Socio() {}
    
    public Socio(String nome, String cpf, Categoria categoria, String dataCadastro) {
        super(nome, cpf);
        this.categoria = categoria;
        this.dataCadastro = dataCadastro;
    }
    
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    
    public String getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(String dataCadastro) { this.dataCadastro = dataCadastro; }
    
    @Override
    public void exibirDados() {
        System.out.println("=== DADOS DO SÓCIO ===");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Categoria: " + categoria.getNomeCategoria());
        System.out.println("Data de Cadastro: " + dataCadastro);
        System.out.println("Mensalidade: R$ " + String.format("%.2f", categoria.getPrecoMensal()));
    }
    
    public void atualizarDados(String novoNome, Categoria novaCategoria) {
        this.nome = novoNome;
        this.categoria = novaCategoria;
        System.out.println("Dados atualizados com sucesso!");
    }
    
    @Override
    public String toString() {
        return "Socio{nome='" + nome + "', cpf='" + cpf + "', categoria=" + categoria.getNomeCategoria() + 
               ", mensalidade=R$ " + String.format("%.2f", categoria.getPrecoMensal()) + "}";
    }
}