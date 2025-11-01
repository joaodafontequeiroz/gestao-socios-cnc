package exception;

public class CPFInvalidoException extends Exception {
    public CPFInvalidoException(String message) {
        super(message);
    }
    
    public CPFInvalidoException(String cpf, String motivo) {
        super("CPF " + cpf + " inválido: " + motivo);
    }
}