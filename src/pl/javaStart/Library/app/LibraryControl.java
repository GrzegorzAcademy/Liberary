package pl.javaStart.Library.app;

import pl.javaStart.Library.model.Book;
import pl.javaStart.Library.model.Library;

public class LibraryControl {
    private final int exit = 0;
    private final int addBook = 1;
    private  final  int printBooks = 2;

    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop() {
        int option;

        do {
            printOptions();
            option = dataReader.getInt();
            switch (option) {
                case addBook:
                    addBook();
                    break;
                case printBooks:
                    printBooks();
                    break;
                case exit:
                    exit();
            }
        } while (option!= exit);
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