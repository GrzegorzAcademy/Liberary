package pl.javaStart.Library.app;

import pl.javaStart.Library.exeptions.DataExportExeption;
import pl.javaStart.Library.exeptions.DataImportExeption;
import pl.javaStart.Library.exeptions.InvalidDataExeption;
import pl.javaStart.Library.io.ConsolePrinter;
import pl.javaStart.Library.io.DataReader;
import pl.javaStart.Library.io.file.FileMenagerBuldier;
import pl.javaStart.Library.io.file.Filemenager;
import pl.javaStart.Library.model.Book;
import pl.javaStart.Library.model.Library;
import pl.javaStart.Library.model.Magazine;
import pl.javaStart.Library.model.Publication;

import java.util.InputMismatchException;

public class LibraryControl {


    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private Library library;
    private Filemenager fileMenager;


    LibraryControl() {
        fileMenager = new FileMenagerBuldier(printer, dataReader).bulid();
        try {
            library = fileMenager.importdata();
            printer.printLine("Zaimportowano dane z pliku ");
        } catch (DataImportExeption | InvalidDataExeption e) {
            printer.printLine(e.getMessage());
            printer.printLine("zainicjowano nową bazę ");
            library = new Library();
        }
    }

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
                case DELETE_BOOK:
                    deleteBooks();
                    break;
                case DELETE_MAGAZINE:
                    deleteMagazin();
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
            library.addPublication(magazine);
        } catch (InputMismatchException e) {
            printer.printLine("podano nieprawidłwe dane");

        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("osiagnięto limit pojemności");
        }
    }

    private void deleteMagazin() {
        try{
            Magazine magazine = dataReader.readAndCreateMagazine();
            if (library.removePublication(magazine))
                printer.printLine("Magazyn został usunięty");
            else
                printer.printLine(" Brak magazynu");
        } catch (InputMismatchException e){
            printer.printLine("Nie udało sie usunąć magazynu błęðne dane");
        }
    }

    private void printOptions() {
        printer.printLine("Wybierz opcje");
        for (Option option : Option.values()) {
            printer.printLine(option.toString());
        }
    }

    private void exit() {
        try {
            fileMenager.exportData(library);
            printer.printLine("Dane zostay zaktualizowane ");
        } catch (DataExportExeption e) {
            printer.printLine(e.getMessage());
        }
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
            library.addPublication(book);
        } catch (InputMismatchException e) {
            printer.printLine("podano nieprawidłwe dane");

        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("osiagnięto limit pojemności");
        }
    }

    private void deleteBooks() {
        try {
            Book book = dataReader.readAndCreateBook();
            if (library.removePublication(book)) {
                printer.printLine(" Ksiązka została usunięta");
            } else {
                printer.printLine("Brak wskazanej ksiązki");
            }
        }catch (InputMismatchException e ){
            printer.printLine("Nie udało się usunąc książki, błędne dane");

        }
    }

    public enum Option {
        EXIT(0, "Wyjście z programu"),
        ADD_BOOK(1, "Dodanie nowej książki"),
        PRINT_BOOKS(2, "Dostępne książki"),
        ADD_MAGAZINES(3, "Dodanie magazynu"),
        PRINT_MAGAZINES(4, "Wyswietl dostępne magazyny"),
        DELETE_BOOK(5, "Usuń książkę"),
        DELETE_MAGAZINE(6, "Usuń magazyn");
        private final int value;
        private final String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        public int getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }

        static Option createFromInt(int option) throws NoSuchFieldException {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchFieldException("no option with id try again " + option);
            }
        }
    }
}