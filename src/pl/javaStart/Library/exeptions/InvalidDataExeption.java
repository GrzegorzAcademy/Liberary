package pl.javaStart.Library.exeptions;

public class InvalidDataExeption extends RuntimeException{
    public InvalidDataExeption(String message) {
        super(message);
    }
}
