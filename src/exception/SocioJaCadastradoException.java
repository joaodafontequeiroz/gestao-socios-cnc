package exception;

public class SocioJaCadastradoException extends Exception {
    public SocioJaCadastradoException(String cpf) {
        super("Sócio com CPF " + cpf + " já está cadastrado!");
    }
}