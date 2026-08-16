package exception;

public class CategoriaInvalidaException extends Exception {
    public CategoriaInvalidaException(String message) {
        super(message);
    }
    
    public CategoriaInvalidaException(int numeroCategoria) {
        super("Categoria número " + numeroCategoria + " é inválida!");
    }
}