package model;

import java.io.Serializable;

public class Categoria implements Serializable {
    private String nomeCategoria;
    private String beneficios;
    private double precoMensal;
    
    public Categoria() {}
    
    public Categoria(String nomeCategoria, String beneficios, double precoMensal) {
        this.nomeCategoria = nomeCategoria;
        this.beneficios = beneficios;
        this.precoMensal = precoMensal;
    }
    
    public Categoria(String nomeCategoria, String beneficios) {
        this(nomeCategoria, beneficios, 0.0);
    }
    
    public String getNomeCategoria() { return nomeCategoria; }
    public void setNomeCategoria(String nomeCategoria) { this.nomeCategoria = nomeCategoria; }
    
    public String getBeneficios() { return beneficios; }
    public void setBeneficios(String beneficios) { this.beneficios = beneficios; }
    
    public double getPrecoMensal() { return precoMensal; }
    public void setPrecoMensal(double precoMensal) { this.precoMensal = precoMensal; }
    
    public void exibirBeneficios() {
        if (precoMensal > 0) {
            System.out.println("Categoria: " + nomeCategoria + " - R$ " + String.format("%.2f", precoMensal) + "/mês");
        } else {
            System.out.println("Categoria: " + nomeCategoria + " - Gratuita");
        }
        System.out.println("Benefícios: " + beneficios);
    }
    
    @Override
    public String toString() {
        if (precoMensal > 0) {
            return String.format("%s - R$ %.2f/mês - %s", nomeCategoria, precoMensal, beneficios);
        } else {
            return String.format("%s - Gratuito - %s", nomeCategoria, beneficios);
        }
    }
}