package pl.javaStart.Library.app;

import pl.javaStart.Library.model.Book;
import pl.javaStart.Library.model.Library;
import pl.javaStart.Library.model.Magazine;

public class LibraryControl {
    private static final int EXIT = 0;
    private static final int ADD_BOOK = 1;
    private static final  int PRINT_BOOKS = 2;
    private static final int ADD_MAGAZINE = 3;
    private static final  int PRINT_MAGAZINE = 4;

    private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop() {
        int option;
        do {
            printOptions();
            option = dataReader.getInt();
            switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                    case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break; 
                    case PRINT_MAGAZINE:
                    printMagazines();
                    break;
                case EXIT:
                    exit();
            }
        } while (option!= EXIT);
    }

    private void printMagazines() {
        library.printMagazines();
    }

    private void addMagazine() {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }

    private void printOptions () {
            System.out.println("Wybierz opcje");
            System.out.println(EXIT + "  wyjscie z programu");
            System.out.println(ADD_BOOK +"  odanie noewj książki ");
            System.out.println(PRINT_BOOKS + "  dostepne książki");
            System.out.println(ADD_MAGAZINE + "  Dodanie magazynu");
            System.out.println(PRINT_MAGAZINE + "  Wysietlanie dostepnych magazynów");
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