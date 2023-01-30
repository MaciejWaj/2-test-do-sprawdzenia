package pl.kurs.test2rozszerzenie.exception;

public class UnknownOperatorException extends RuntimeException{

    public UnknownOperatorException(String message) {
        super(message);
    }
}
