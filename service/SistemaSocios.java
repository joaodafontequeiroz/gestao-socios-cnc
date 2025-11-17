package service;

import model.Socio;
import model.Categoria;
import util.FileManager;
import exception.*;
import patterns.AutoSaveThread;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaSocios {
    
    private static SistemaSocios instancia;
    
    private ArrayList<Socio> socios;
    private ArrayList<Categoria> categorias;
    private Scanner scanner;
    private AutoSaveThread autoSaveThread;
    
    
    private SistemaSocios() {
        this.socios = FileManager.carregarSocios();
        this.categorias = FileManager.carregarCategorias();
        this.scanner = new Scanner(System.in);
        
        if (categorias.isEmpty()) {
            inicializarCategoriasReais();
        }
        
        
        this.autoSaveThread = new AutoSaveThread(this);
        this.autoSaveThread.start();
        
        System.out.println("Sistema de Sócios inicializado");
        System.out.println("Auto-save ativado (a cada 30 segundos)");
    }
    
    
    public static SistemaSocios getInstancia() {
        if (instancia == null) {
            instancia = new SistemaSocios();
        }
        return instancia;
    }
    
    private void inicializarCategoriasReais() {
        categorias.add(new Categoria("100% TIMBA", "100% desconto TODOS setores + camisas oficiais 2025", 399.90));
        categorias.add(new Categoria("BRANCO DE PAZ", "100% desconto Hexa, Vermelho e Caldeirão", 99.90));
        categorias.add(new Categoria("PATRIMONIAL", "70% desconto Vermelho e Hexa (Jóia: R$ 3.000,00)", 79.90));
        categorias.add(new Categoria("VERMELHO DE LUTA", "100% desconto Caldeirão + 60% Hexa/Vermelho", 39.90));
        categorias.add(new Categoria("SÓCIO CALDEIRÃO", "100% desconto Setor Caldeirão", 24.90));
        categorias.add(new Categoria("AQUISIÇÃO DE CADEIRA", "Prioridade 1ª ingresso (Jóia: R$ 3.000,00)", 0.0));
        categorias.add(new Categoria("TODO MUNDO É NÁUTICO", "Prioridade 4ª ingresso (Taxa: R$ 25,00 carteira)", 0.0));
        categorias.add(new Categoria("TIMBU +", "100% desconto titular + 1 acompanhante (PCD)", 0.0));
        
        FileManager.salvarCategorias(categorias);
        System.out.println("Categorias oficiais do Clube Náutico Capibaribe carregadas!");
    }
    
    public void salvarDados() {
        FileManager.salvarSocios(socios);
        FileManager.salvarCategorias(categorias);
    }
    
    public void cadastrarSocio(Socio socio) throws SocioJaCadastradoException, CPFInvalidoException {
        if (encontrarSocioPorCPF(socio.getCpf()) != null) {
            throw new SocioJaCadastradoException(socio.getCpf());
        }
        
        socios.add(socio);
        salvarDados();
    }
    
    public void editarSocio(String cpf) throws SocioNaoEncontradoException, CPFInvalidoException, CategoriaInvalidaException {
        Socio socio = encontrarSocioPorCPF(cpf);
        if (socio == null) {
            throw new SocioNaoEncontradoException(cpf);
        }
        
        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();
        
        System.out.println("Categorias disponíveis:");
        listarCategorias();
        System.out.print("Nova categoria (número): ");
        
        String entrada = scanner.nextLine();
        int categoriaIndex;
        
        try {
            categoriaIndex = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            throw new CategoriaInvalidaException("Digite um número válido!");
        }
        
        if (categoriaIndex < 1 || categoriaIndex > categorias.size()) {
            throw new CategoriaInvalidaException(categoriaIndex);
        }
        
        Categoria novaCategoria = categorias.get(categoriaIndex - 1);
        socio.atualizarDados(novoNome, novaCategoria);
        salvarDados();
    }
    
    public void removerSocio(String cpf) throws SocioNaoEncontradoException, CPFInvalidoException {
        boolean encontrou = false;
        for (int i = 0; i < socios.size(); i++) {
            if (socios.get(i).getCpf().equals(cpf)) {
                socios.remove(i);
                salvarDados();
                encontrou = true;
                break;
            }
        }
        
        if (!encontrou) {
            throw new SocioNaoEncontradoException(cpf);
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
    
    public void adicionarCategoria() throws IllegalArgumentException {
        System.out.print("Nome da nova categoria: ");
        String nome = scanner.nextLine();
        
        System.out.print("Benefícios: ");
        String beneficios = scanner.nextLine();
        
        if (beneficios.trim().isEmpty()) {
            throw new IllegalArgumentException("Benefícios não podem estar vazios!");
        }
        
        System.out.print("Preço mensal (R$): ");
        String entradaPreco = scanner.nextLine();
        
        double preco;
        try {
            preco = Double.parseDouble(entradaPreco);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Digite um preço válido!");
        }
        
        Categoria novaCategoria = new Categoria(nome, beneficios, preco);
        categorias.add(novaCategoria);
        salvarDados();
    }
    
    public void editarCategoria() throws CategoriaInvalidaException, IllegalArgumentException {
        listarCategorias();
        
        if (categorias.isEmpty()) {
            throw new IllegalStateException("Não há categorias para editar.");
        }
        
        System.out.print("Número da categoria a editar: ");
        String entrada = scanner.nextLine();
        
        int index;
        try {
            index = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            throw new CategoriaInvalidaException("Digite um número válido!");
        }
        
        if (index < 1 || index > categorias.size()) {
            throw new CategoriaInvalidaException(index);
        }
        
        Categoria categoria = categorias.get(index - 1);
        System.out.println("Editando: " + categoria.getNomeCategoria());
        
        System.out.print("Novos benefícios: ");
        String novosBeneficios = scanner.nextLine();
        
        if (novosBeneficios.trim().isEmpty()) {
            throw new IllegalArgumentException("Benefícios não podem estar vazios!");
        }
        
        System.out.print("Novo preço mensal (R$): ");
        String entradaPreco = scanner.nextLine();
        
        double novoPreco;
        try {
            novoPreco = Double.parseDouble(entradaPreco);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Digite um preço válido!");
        }
        
        categoria.setBeneficios(novosBeneficios);
        categoria.setPrecoMensal(novoPreco);
        salvarDados();
    }
    
    public void removerCategoria() throws CategoriaInvalidaException {
        listarCategorias();
        
        if (categorias.isEmpty()) {
            throw new IllegalStateException("Não há categorias para remover.");
        }
        
        System.out.print("Número da categoria a remover: ");
        String entrada = scanner.nextLine();
        
        int index;
        try {
            index = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            throw new CategoriaInvalidaException("Digite um número válido!");
        }
        
        if (index < 1 || index > categorias.size()) {
            throw new CategoriaInvalidaException(index);
        }
        
        categorias.remove(index - 1);
        salvarDados();
    }
    
    public ArrayList<Socio> getSocios() { return socios; }
    public ArrayList<Categoria> getCategorias() { return categorias; }
    
    public Socio encontrarSocioPorCPF(String cpf) {
        for (Socio socio : socios) {
            if (socio.getCpf().equals(cpf)) {
                return socio;
            }
        }
        return null;
    }
    
    public void finalizarSistema() {
        if (autoSaveThread != null) {
            autoSaveThread.parar();
        }
        salvarDados();
        System.out.println("Sistema finalizado com segurança");
    }
}