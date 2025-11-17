package exception;

public class SocioNaoEncontradoException extends Exception {
    
    public SocioNaoEncontradoException(String cpf) {
        super("Sócio com CPF " + cpf + " não encontrado!");
    }
}