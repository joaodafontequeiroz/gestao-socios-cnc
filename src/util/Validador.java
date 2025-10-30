package util;

public class Validador {
    
    public static boolean validarCPF(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            return false;
        }
        
        cpf = cpf.replace(".", "").replace("-", "");
        
        if (cpf.length() != 11) {
            return false;
        }
        
        try {
            Long.parseLong(cpf);
        } catch (NumberFormatException e) {
            return false;
        }
        
        return true;
    }
    
    public static boolean validarNome(String nome) {
        return nome != null && nome.trim().length() >= 2;
    }
}