package service;

import model.Socio;
import model.Categoria;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe principal do sistema - Gerencia todos os sócios e categorias
 */
public class SistemaSocios {
    private ArrayList<Socio> socios;
    private ArrayList<Categoria> categorias;
    private Scanner scanner;
    
    public SistemaSocios() {
        this.socios = new ArrayList<>();
        this.categorias = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        inicializarCategoriasPadrao();
    }
    
    private void inicializarCategoriasPadrao() {
        categorias.add(new Categoria("Júnior", "Acesso diurno, aulas de natação"));
        categorias.add(new Categoria("Adulto", "Acesso integral, estacionamento, academia"));
        categorias.add(new Categoria("Família", "Acesso familiar, área kids, desconto em eventos"));
        categorias.add(new Categoria("Premium", "Área VIP, estacionamento coberto, convidados ilimitados"));
    }
    
    // MÉTODOS PARA SÓCIOS
    public void cadastrarSocio(Socio socio) {
        socios.add(socio);
        System.out.println("Sócio cadastrado com sucesso!");
    }
    
    public void editarSocio(String cpf) {
        for (Socio socio : socios) {
            if (socio.getCpf().equals(cpf)) {
                System.out.print("Novo nome: ");
                String novoNome = scanner.nextLine();
                
                System.out.println("Categorias disponíveis:");
                listarCategorias();
                System.out.print("Nova categoria (número): ");
                int categoriaIndex = scanner.nextInt();
                scanner.nextLine();
                
                if (categoriaIndex >= 1 && categoriaIndex <= categorias.size()) {
                    Categoria novaCategoria = categorias.get(categoriaIndex - 1);
                    socio.atualizarDados(novoNome, novaCategoria);
                    System.out.println("Sócio editado com sucesso!");
                } else {
                    System.out.println("Categoria inválida!");
                }
                return;
            }
        }
        System.out.println("Sócio não encontrado!");
    }
    
    public void removerSocio(String cpf) {
        for (int i = 0; i < socios.size(); i++) {
            if (socios.get(i).getCpf().equals(cpf)) {
                socios.remove(i);
                System.out.println("Sócio removido com sucesso!");
                return;
            }
        }
        System.out.println("Sócio não encontrado!");
    }
    
    public void listarSocios() {
        if (socios.isEmpty()) {
            System.out.println("Nenhum sócio cadastrado.");
        } else {
            System.out.println("=== LISTA DE SÓCIOS ===");
            for (int i = 0; i < socios.size(); i++) {
                System.out.println((i + 1) + ". " + socios.get(i));
            }
        }
    }
    
    // MÉTODOS PARA CATEGORIAS - NOVAS FUNCIONALIDADES!
    public void listarCategorias() {
        System.out.println("=== CATEGORIAS DISPONÍVEIS ===");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + ". " + categorias.get(i));
        }
    }
    
    public void adicionarCategoria() {
        System.out.print("Nome da nova categoria: ");
        String nome = scanner.nextLine();
        
        System.out.print("Benefícios: ");
        String beneficios = scanner.nextLine();
        
        Categoria novaCategoria = new Categoria(nome, beneficios);
        categorias.add(novaCategoria);
        System.out.println("✅ Categoria '" + nome + "' adicionada com sucesso!");
    }
    
    public void editarCategoria() {
        listarCategorias();
        
        if (categorias.isEmpty()) {
            System.out.println("Não há categorias para editar.");
            return;
        }
        
        System.out.print("Número da categoria a editar: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        
        if (index >= 1 && index <= categorias.size()) {
            Categoria categoria = categorias.get(index - 1);
            
            System.out.println("Editando: " + categoria.getNomeCategoria());
            System.out.print("Novos benefícios: ");
            String novosBeneficios = scanner.nextLine();
            
            categoria.setBeneficios(novosBeneficios);
            System.out.println("✅ Benefícios atualizados com sucesso!");
        } else {
            System.out.println("❌ Categoria inválida!");
        }
    }
    
    public void removerCategoria() {
        listarCategorias();
        
        if (categorias.isEmpty()) {
            System.out.println("Não há categorias para remover.");
            return;
        }
        
        System.out.print("Número da categoria a remover: ");
        int index = scanner.nextInt();
        scanner.nextLine();
        
        if (index >= 1 && index <= categorias.size()) {
            Categoria categoriaRemovida = categorias.remove(index - 1);
            System.out.println("✅ Categoria '" + categoriaRemovida.getNomeCategoria() + "' removida com sucesso!");
        } else {
            System.out.println("❌ Categoria inválida!");
        }
    }
    
    // GETTERS
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }
    
    public ArrayList<Socio> getSocios() {
        return socios;
    }
    
    public Socio encontrarSocioPorCPF(String cpf) {
        for (Socio socio : socios) {
            if (socio.getCpf().equals(cpf)) {
                return socio;
            }
        }
        return null;
    }
}