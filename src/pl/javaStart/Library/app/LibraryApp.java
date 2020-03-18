package pl.javaStart.Library.app;

public class LibraryApp {
    public static void main(String[] args) {
        final String appName = "Biblioteka 1.6";
        System.out.println(appName);
        LibraryControl libraryControl = new LibraryControl();
        libraryControl.controlLoop();
    }
}
