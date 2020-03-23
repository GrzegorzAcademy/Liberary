package pl.javaStart.Library.io;

import pl.javaStart.Library.model.Book;
import pl.javaStart.Library.model.Magazine;

import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    public Book readAndCreateBook() {
        printer.printLine("Tytuł");
        String title = sc.nextLine();
        printer.printLine("Autor");
        String author = sc.nextLine();
        printer.printLine("Wydawnictwo");
        String publisher = sc.nextLine();
        printer.printLine("ISBN");
        String isbn = sc.nextLine();
        printer.printLine("Rok Wydania");
        int relaseDate = getInt();
        printer.printLine("Liczba stron");
        int pages = getInt();
        return new Book(title, author, relaseDate, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() {
        printer.printLine(" Tytuł");
        String title = sc.nextLine();
        printer.printLine(" Wydwnictwo");
        String publisher = sc.nextLine();
        printer.printLine(" Język");
        String langaue = sc.nextLine();
        printer.printLine(" Rok Wydania");
        int year = getInt();
        printer.printLine(" Miesiac ");
        int month = sc.nextInt();
        printer.printLine(" Dzień ");
        int day = getInt();

        return new Magazine(title, publisher, langaue, year, month, day);
    }

    public int getInt() {
        try {
            return sc.nextInt();
        } finally {
            sc.nextLine();
        }
    }

    public String getString() {
        return sc.nextLine();
    }

    public void close() {
        sc.close();
    }
}
