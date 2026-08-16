package util;

import exception.CPFInvalidoException;

public class Validador {
    public static void validarCPF(String cpf) throws CPFInvalidoException {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new CPFInvalidoException("CPF não pode ser vazio!");
        }
        
        cpf = cpf.replace(".", "").replace("-", "");
        
        if (cpf.length() != 11) {
            throw new CPFInvalidoException(cpf, "deve ter 11 dígitos");
        }
        
        try {
            Long.parseLong(cpf);
        } catch (NumberFormatException e) {
            throw new CPFInvalidoException(cpf, "deve conter apenas números");
        }
    }
    
    public static boolean validarNome(String nome) {
        return nome != null && nome.trim().length() >= 2;
    }
}