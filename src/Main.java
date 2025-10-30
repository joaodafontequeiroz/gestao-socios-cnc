import view.InterfaceCLI;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando Sistema de Gestão de Sócios - ETAPA 4");
        System.out.println("Clube Náutico Capibaribe - Categorias Oficiais");
        
        InterfaceCLI interfaceCLI = new InterfaceCLI();
        interfaceCLI.mostrarMenuPrincipal();
        
        System.out.println("Sistema finalizado.");
    }
}