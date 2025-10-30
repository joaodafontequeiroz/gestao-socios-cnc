package view;

import service.SistemaSocios;
import model.Socio;
import model.Categoria;
import model.Administrador;
import util.Validador;
import java.util.Scanner;

public class InterfaceCLI {
    private SistemaSocios sistema;
    private Scanner scanner;
    private Administrador admin;
    
    public InterfaceCLI() {
        this.sistema = new SistemaSocios();
        this.scanner = new Scanner(System.in);
        this.admin = new Administrador("Admin", "admin", "1234");
    }
    
    public void mostrarMenuPrincipal() {
        while (true) {
            System.out.println("\n⚓ SISTEMA DE GESTÃO DE SÓCIOS - CLUBE NÁUTICO CAPIBARIBE");
            System.out.println("1. Acesso Administrador");
            System.out.println("2. Acesso Sócio");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            
            String entrada = scanner.nextLine();
            
            try {
                int opcao = Integer.parseInt(entrada);
                
                switch (opcao) {
                    case 1:
                        autenticarAdministrador();
                        break;
                    case 2:
                        mostrarMenuSocio();
                        break;
                    case 3:
                        System.out.println("Saindo do sistema...");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido!");
            }
        }
    }
    
    private void autenticarAdministrador() {
        System.out.print("Login: ");
        String login = scanner.nextLine();
        
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        
        if (admin.autenticar(login, senha)) {
            mostrarMenuAdministrador();
        } else {
            System.out.println("Credenciais inválidas!");
        }
    }
    
    private void mostrarMenuAdministrador() {
        while (true) {
            System.out.println("\n🔧 MENU ADMINISTRADOR");
            System.out.println("1. Cadastrar Sócio");
            System.out.println("2. Editar Sócio");
            System.out.println("3. Excluir Sócio");
            System.out.println("4. Consultar Lista de Sócios");
            System.out.println("5. Gerenciar Categorias");
            System.out.println("6. Voltar");
            System.out.print("Escolha uma opção: ");
            
            String entrada = scanner.nextLine();
            
            try {
                int opcao = Integer.parseInt(entrada);
                
                switch (opcao) {
                    case 1:
                        cadastrarSocio();
                        break;
                    case 2:
                        editarSocio();
                        break;
                    case 3:
                        removerSocio();
                        break;
                    case 4:
                        sistema.listarSocios();
                        break;
                    case 5:
                        gerenciarCategorias();
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido!");
            }
        }
    }
    
    private void gerenciarCategorias() {
        while (true) {
            System.out.println("\n📊 GERENCIAR CATEGORIAS");
            System.out.println("1. Listar categorias");
            System.out.println("2. Adicionar nova categoria");
            System.out.println("3. Editar benefícios de categoria");
            System.out.println("4. Remover categoria");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            
            String entrada = scanner.nextLine();
            
            try {
                int opcao = Integer.parseInt(entrada);
                
                switch (opcao) {
                    case 1:
                        sistema.listarCategorias();
                        break;
                    case 2:
                        sistema.adicionarCategoria();
                        break;
                    case 3:
                        sistema.editarCategoria();
                        break;
                    case 4:
                        sistema.removerCategoria();
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido!");
            }
        }
    }
    
    private void mostrarMenuSocio() {
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        
        if (!Validador.validarCPF(cpf)) {
            System.out.println("CPF inválido!");
            return;
        }
        
        Socio socio = sistema.encontrarSocioPorCPF(cpf);
        if (socio == null) {
            System.out.println("Sócio não encontrado!");
            return;
        }
        
        while (true) {
            System.out.println("\n👤 MENU SÓCIO - " + socio.getNome());
            System.out.println("1. Visualizar Dados");
            System.out.println("2. Atualizar Informações");
            System.out.println("3. Consultar Categoria");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            
            String entrada = scanner.nextLine();
            
            try {
                int opcao = Integer.parseInt(entrada);
                
                switch (opcao) {
                    case 1:
                        socio.visualizarDados();
                        break;
                    case 2:
                        atualizarDadosSocio(socio);
                        break;
                    case 3:
                        socio.getCategoria().exibirBeneficios();
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido!");
            }
        }
    }
    
    private void cadastrarSocio() {
        System.out.println("\n📋 CADASTRAR NOVO SÓCIO");
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        if (!Validador.validarNome(nome)) {
            System.out.println("Nome inválido!");
            return;
        }
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        if (!Validador.validarCPF(cpf)) {
            System.out.println("CPF inválido!");
            return;
        }
        
        System.out.println("Categorias disponíveis:");
        sistema.listarCategorias();
        System.out.print("Escolha a categoria (número): ");
        
        try {
            String entrada = scanner.nextLine();
            int categoriaIndex = Integer.parseInt(entrada);
            
            if (categoriaIndex < 1 || categoriaIndex > sistema.getCategorias().size()) {
                System.out.println("Categoria inválida!");
                return;
            }
            
            Categoria categoria = sistema.getCategorias().get(categoriaIndex - 1);
            String dataAtual = java.time.LocalDate.now().toString();
            
            Socio novoSocio = new Socio(nome, cpf, categoria, dataAtual);
            sistema.cadastrarSocio(novoSocio);
            
        } catch (NumberFormatException e) {
            System.out.println("Digite um número válido!");
        }
    }
    
    private void editarSocio() {
        System.out.print("CPF do sócio a editar: ");
        String cpf = scanner.nextLine();
        sistema.editarSocio(cpf);
    }
    
    private void removerSocio() {
        System.out.print("CPF do sócio a remover: ");
        String cpf = scanner.nextLine();
        sistema.removerSocio(cpf);
    }
    
    private void atualizarDadosSocio(Socio socio) {
        System.out.print("Novo nome: ");
        String novoNome = scanner.nextLine();
        
        if (!Validador.validarNome(novoNome)) {
            System.out.println("Nome inválido!");
            return;
        }
        
        System.out.println("Categorias disponíveis:");
        sistema.listarCategorias();
        System.out.print("Nova categoria (número): ");
        
        try {
            String entrada = scanner.nextLine();
            int categoriaIndex = Integer.parseInt(entrada);
            
            if (categoriaIndex < 1 || categoriaIndex > sistema.getCategorias().size()) {
                System.out.println("Categoria inválida!");
                return;
            }
            
            Categoria novaCategoria = sistema.getCategorias().get(categoriaIndex - 1);
            socio.atualizarDados(novoNome, novaCategoria);
            
        } catch (NumberFormatException e) {
            System.out.println("Digite um número válido!");
        }
    }
}