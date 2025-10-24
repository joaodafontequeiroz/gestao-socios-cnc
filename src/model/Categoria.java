package model;

/**
 * Classe que representa uma Categoria de sócio
 */
public class Categoria {
    private String nomeCategoria;
    private String beneficios;
    
    public Categoria() {
    }
    
    public Categoria(String nomeCategoria, String beneficios) {
        this.nomeCategoria = nomeCategoria;
        this.beneficios = beneficios;
    }
    
    public String getNomeCategoria() {
        return nomeCategoria;
    }
    
    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
    
    public String getBeneficios() {
        return beneficios;
    }
    
    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }
    
    public void exibirBeneficios() {
        System.out.println("Benefícios da categoria " + nomeCategoria + ": " + beneficios);
    }
    
    @Override
    public String toString() {
        return nomeCategoria + " - " + beneficios;
    }
}