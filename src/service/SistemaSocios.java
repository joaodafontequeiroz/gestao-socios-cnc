package service;

import model.Socio;
import model.Categoria;
import util.FileManager;
import util.Validador;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaSocios {
    private ArrayList<Socio> socios;
    private ArrayList<Categoria> categorias;
    private Scanner scanner;
    
    public SistemaSocios() {
        this.socios = FileManager.carregarSocios();
        this.categorias = FileManager.carregarCategorias();
        this.scanner = new Scanner(System.in);
        
        if (categorias.isEmpty()) {
            inicializarCategoriasReais();
        }
    }
    
    private void inicializarCategoriasReais() {
        // ✅ CATEGORIAS OFICIAIS DO CLUBE NÁUTICO CAPIBARIBE
        categorias.add(new Categoria("100% TIMBA", "100% desconto TODOS setores + camisas oficiais 2025", 399.90));
        categorias.add(new Categoria("BRANCO DE PAZ", "100% desconto Hexa, Vermelho e Caldeirão", 99.90));
        categorias.add(new Categoria("PATRIMONIAL", "70% desconto Vermelho e Hexa (Jóia: R$ 3.000,00)", 79.90));
        categorias.add(new Categoria("VERMELHO DE LUTA", "100% desconto Caldeirão + 60% Hexa/Vermelho", 39.90));
        categorias.add(new Categoria("SÓCIO CALDEIRÃO", "100% desconto Setor Caldeirão", 24.90));
        categorias.add(new Categoria("AQUISIÇÃO DE CADEIRA", "Prioridade 1ª ingresso (Jóia: R$ 3.000,00)", 0.0));
        categorias.add(new Categoria("TODO MUNDO É NÁUTICO", "Prioridade 4ª ingresso (Taxa: R$ 25,00 carteira)", 0.0));
        categorias.add(new Categoria("TIMBU +", "100% desconto titular + 1 acompanhante (PCD)", 0.0));
        
        FileManager.salvarCategorias(categorias);
        System.out.println("✅ Categorias oficiais do Clube Náutico Capibaribe carregadas!");
    }
    
    private void salvarDados() {
        FileManager.salvarSocios(socios);
        FileManager.salvarCategorias(categorias);
    }
    
    public void cadastrarSocio(Socio socio) {
        try {
            if (!Validador.validarCPF(socio.getCpf())) {
                System.out.println("CPF inválido! Deve ter 11 dígitos.");
                return;
            }
            
            if (encontrarSocioPorCPF(socio.getCpf()) != null) {
                System.out.println("CPF já cadastrado!");
                return;
            }
            
            if (!Validador.validarNome(socio.getNome())) {
                System.out.println("Nome inválido! Deve ter pelo menos 2 caracteres.");
                return;
            }
            
            socios.add(socio);
            salvarDados();
            System.out.println("Sócio cadastrado com sucesso!");
            
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar sócio: " + e.getMessage());
        }
    }
    
    public void editarSocio(String cpf) {
        try {
            Socio socio = encontrarSocioPorCPF(cpf);
            if (socio == null) {
                System.out.println("Sócio não encontrado!");
                return;
            }
            
            System.out.print("Novo nome: ");
            String novoNome = scanner.nextLine();
            
            if (!Validador.validarNome(novoNome)) {
                System.out.println("Nome inválido!");
                return;
            }
            
            System.out.println("Categorias disponíveis:");
            listarCategorias();
            System.out.print("Nova categoria (número): ");
            
            String entrada = scanner.nextLine();
            int categoriaIndex = Integer.parseInt(entrada);
            
            if (categoriaIndex < 1 || categoriaIndex > categorias.size()) {
                System.out.println("Categoria inválida!");
                return;
            }
            
            Categoria novaCategoria = categorias.get(categoriaIndex - 1);
            socio.atualizarDados(novoNome, novaCategoria);
            salvarDados();
            System.out.println("Sócio editado com sucesso!");
            
        } catch (NumberFormatException e) {
            System.out.println("Digite um número válido!");
        } catch (Exception e) {
            System.out.println("Erro ao editar sócio: " + e.getMessage());
        }
    }
    
    public void removerSocio(String cpf) {
        try {
            if (!Validador.validarCPF(cpf)) {
                System.out.println("CPF inválido!");
                return;
            }
            
            boolean encontrou = false;
            for (int i = 0; i < socios.size(); i++) {
                if (socios.get(i).getCpf().equals(cpf)) {
                    socios.remove(i);
                    salvarDados();
                    System.out.println("Sócio removido com sucesso!");
                    encontrou = true;
                    break;
                }
            }
            
            if (!encontrou) {
                System.out.println("Sócio não encontrado!");
            }
            
        } catch (Exception e) {
            System.out.println("Erro ao remover sócio: " + e.getMessage());
        }
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
    
    public void listarCategorias() {
        System.out.println("=== CATEGORIAS OFICIAIS DO CLUBE ===");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + ". " + categorias.get(i));
        }
    }
    
    public void adicionarCategoria() {
        try {
            System.out.print("Nome da nova categoria: ");
            String nome = scanner.nextLine();
            
            if (!Validador.validarNome(nome)) {
                System.out.println("Nome inválido!");
                return;
            }
            
            System.out.print("Benefícios: ");
            String beneficios = scanner.nextLine();
            
            if (beneficios.trim().isEmpty()) {
                System.out.println("Benefícios não podem estar vazios!");
                return;
            }
            
            System.out.print("Preço mensal (R$): ");
            double preco = Double.parseDouble(scanner.nextLine());
            
            Categoria novaCategoria = new Categoria(nome, beneficios, preco);
            categorias.add(novaCategoria);
            salvarDados();
            System.out.println("Categoria adicionada com sucesso!");
            
        } catch (NumberFormatException e) {
            System.out.println("Digite um preço válido!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar categoria: " + e.getMessage());
        }
    }
    
    public void editarCategoria() {
        try {
            listarCategorias();
            
            if (categorias.isEmpty()) {
                System.out.println("Não há categorias para editar.");
                return;
            }
            
            System.out.print("Número da categoria a editar: ");
            String entrada = scanner.nextLine();
            int index = Integer.parseInt(entrada);
            
            if (index < 1 || index > categorias.size()) {
                System.out.println("Categoria inválida!");
                return;
            }
            
            Categoria categoria = categorias.get(index - 1);
            System.out.println("Editando: " + categoria.getNomeCategoria());
            
            System.out.print("Novos benefícios: ");
            String novosBeneficios = scanner.nextLine();
            
            if (novosBeneficios.trim().isEmpty()) {
                System.out.println("Benefícios não podem estar vazios!");
                return;
            }
            
            System.out.print("Novo preço mensal (R$): ");
            double novoPreco = Double.parseDouble(scanner.nextLine());
            
            categoria.setBeneficios(novosBeneficios);
            categoria.setPrecoMensal(novoPreco);
            salvarDados();
            System.out.println("Categoria atualizada com sucesso!");
            
        } catch (NumberFormatException e) {
            System.out.println("Digite valores numéricos válidos!");
        } catch (Exception e) {
            System.out.println("Erro ao editar categoria: " + e.getMessage());
        }
    }
    
    public void removerCategoria() {
        try {
            listarCategorias();
            
            if (categorias.isEmpty()) {
                System.out.println("Não há categorias para remover.");
                return;
            }
            
            System.out.print("Número da categoria a remover: ");
            String entrada = scanner.nextLine();
            int index = Integer.parseInt(entrada);
            
            if (index < 1 || index > categorias.size()) {
                System.out.println("Categoria inválida!");
                return;
            }
            
            Categoria categoriaRemovida = categorias.remove(index - 1);
            salvarDados();
            System.out.println("Categoria removida com sucesso!");
            
        } catch (NumberFormatException e) {
            System.out.println("Digite um número válido!");
        } catch (Exception e) {
            System.out.println("Erro ao remover categoria: " + e.getMessage());
        }
    }
    
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