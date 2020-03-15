package pl.javaStart.Library.app;

import pl.javaStart.Library.io.ConsolePrinter;
import pl.javaStart.Library.io.DataReader;
import pl.javaStart.Library.model.Book;
import pl.javaStart.Library.model.Library;
import pl.javaStart.Library.model.Magazine;
import pl.javaStart.Library.model.Publication;

import java.util.InputMismatchException;

public class LibraryControl {


    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private Library library = new Library();

    void controlLoop() {
        Option option;
        do {
            printOptions();
            option = getOption();
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
                    break;
                default:
                    printer.printLine("Nie ma takiej opcji, wprowadz ponownie ");
            }
        } while (option != Option.EXIT);
    }

    private Option getOption() {
        boolean optionOK = false;
        Option option = null;
        while (!optionOK) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOK = true;
            } catch (NoSuchFieldException e) {
                printer.printLine(e.getMessage());
            } catch (InputMismatchException e) {
                printer.printLine("Wprowadzono wartość, ktora nie jest liczbą, podaj ponownie ");

            }
        }
        return option;
    }

    private void printMagazines() {
        Publication[] publications = library.getPublications();
        printer.printMagazines(publications);
    }

    private void addMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            library.addMagazine(magazine);
        } catch (InputMismatchException e) {
            printer.printLine("podano nieprawidłwe dane");

        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("osiagnięto limit pojemności");
        }
    }
    private void printOptions() {
        printer.printLine("Wybierz opcje");
        for (Option option : Option.values()) {
            printer.printLine(option.toString());
        }
    }

    private void exit() {
        printer.printLine("Koniec programu");
        dataReader.close();
    }

    private void printBooks() {
        Publication[] publications = library.getPublications();
        printer.printBooks(publications);
    }

    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            library.addBook(book);
        } catch (InputMismatchException e) {
            printer.printLine("podano nieprawidłwe dane");

        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("osiagnięto limit pojemności");
        }
    }
}