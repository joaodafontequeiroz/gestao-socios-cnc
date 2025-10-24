import view.InterfaceCLI;

/**
 * Classe principal do sistema
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("🐋 Iniciando Sistema de Gestão de Sócios...");
        
        InterfaceCLI interfaceCLI = new InterfaceCLI();
        interfaceCLI.mostrarMenuPrincipal();
        
        System.out.println("✅ Sistema finalizado.");
    }
}