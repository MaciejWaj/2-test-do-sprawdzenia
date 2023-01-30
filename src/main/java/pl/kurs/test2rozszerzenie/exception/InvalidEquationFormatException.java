package pl.kurs.test2rozszerzenie.exception;

public class InvalidEquationFormatException extends RuntimeException{

    public InvalidEquationFormatException(String message) {
        super(message);
    }
}
