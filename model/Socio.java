package model;

public class Socio extends Pessoa {
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
    public void exibirInformacoes() {
        System.out.println("=== DADOS DO SÓCIO ===");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Categoria: " + categoria.getNomeCategoria());
        System.out.println("Data de Cadastro: " + dataCadastro);
        System.out.println("Mensalidade: R$ " + String.format("%.2f", categoria.getPrecoMensal()));
        System.out.println("Benefícios: " + categoria.getBeneficios());
    }
    
    public void visualizarDados() {
        exibirInformacoes();
    }
    
    public void atualizarDados(String novoNome, Categoria novaCategoria) {
        this.nome = novoNome;
        this.categoria = novaCategoria;
        System.out.println("Dados atualizados com sucesso!");
    }
    
    @Override
    public String toString() {
        return String.format("Socio{nome='%s', cpf='%s', categoria=%s, mensalidade=R$ %.2f}", 
                           nome, cpf, categoria.getNomeCategoria(), categoria.getPrecoMensal());
    }
}