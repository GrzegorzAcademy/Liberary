package pl.javaStart.Library.exeptions;

public class NoSuchFileTypeExeption extends RuntimeException {
    public NoSuchFileTypeExeption(String message) {
        super(message);
    }
}
