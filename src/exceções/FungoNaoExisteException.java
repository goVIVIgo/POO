package exceções;

public class FungoNaoExisteException extends Exception {
    public FungoNaoExisteException(String message) {
        super(message);
    }
}