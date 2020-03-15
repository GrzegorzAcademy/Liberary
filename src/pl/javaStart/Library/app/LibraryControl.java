package pl.javaStart.Library.app;

import pl.javaStart.Library.io.DataReader;
import pl.javaStart.Library.model.Book;
import pl.javaStart.Library.model.Library;
import pl.javaStart.Library.model.Magazine;

public class LibraryControl {

       private DataReader dataReader = new DataReader();
    private Library library = new Library();

    public void controlLoop() throws NoSuchFieldException {
        Option option;
        do {
            printOptions();
            option = Option.inToInt(dataReader.getInt());
            switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINES:
                    addMagazine();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break; 
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                case EXIT:
                    exit();
            }
        } while (option!= Option.EXIT);
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
        for (Option option : Option.values()) {
            System.out.println(option);
        }
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