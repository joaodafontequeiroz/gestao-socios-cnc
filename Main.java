import view.InterfaceCLI;

public class Main {
    public static void main(String[] args) {
        System.out.println("Clube Náutico Capibaribe - Sistema de Gestão de Sócios");
        
        InterfaceCLI interfaceCLI = new InterfaceCLI();
        interfaceCLI.mostrarMenuPrincipal();
        
        System.out.println("Sistema finalizado com sucesso!");
    }
}
