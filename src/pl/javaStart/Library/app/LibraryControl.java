package pl.javaStart.Library.app;

import pl.javaStart.Library.model.Book;
import pl.javaStart.Library.model.Library;

public class LibraryControl {
    private static final int EXIT = 0;
    private static final int ADDBOOK = 1;
    private static final  int PRINTBOOKS = 2;

    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop() {
        int option;

        do {
            printOptions();
            option = dataReader.getInt();
            switch (option) {
                case ADDBOOK:
                    addBook();
                    break;
                case PRINTBOOKS:
                    printBooks();
                    break;
                case EXIT:
                    exit();
            }
        } while (option!= EXIT);
    }

        private void printOptions () {
            System.out.println("Wybierz opcje");
            System.out.println(" 0 wyjscie z programu");
            System.out.println(" 1 dodanie noewj książki ");
            System.out.println(" 2 dostepne książki");
        }

private void exit() {
        System.out.println("Koniec programu");
        dataReader.close();
    }

    private void printBooks() {
        library.printBooks();
    }

    private void addBook() {
        Book book = dataReader.readAndCreateBook();
        library.addBook(book);
    }
}