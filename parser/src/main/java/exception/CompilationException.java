package exception;

public class CompilationException extends Exception{
    // La excepción que va a tirar por default si algo anda mal
    public CompilationException(String message) {
        super(message);
    }

}
