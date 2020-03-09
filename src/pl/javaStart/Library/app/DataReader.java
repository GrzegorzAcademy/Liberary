package pl.javaStart.Library.app;

import pl.javaStart.Library.model.Book;
import pl.javaStart.Library.model.Magazine;

import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);

    Book readAndCreateBook() {
        System.out.println("Tytuł");
        String title = sc.nextLine();
        System.out.println("Autor");
        String author = sc.nextLine();
        System.out.println("Wydawnictwo");
        String publisher = sc.nextLine();
        System.out.println("ISBN");
        String isbn = sc.nextLine();
        System.out.println("Rok Wydania");
        int relaseDate = getInt();
        System.out.println("Liczba stron");
        int pages =getInt();
        return new Book(title, author, relaseDate, pages, publisher, isbn);
    }
    Magazine readAndCreateMagazine() {
            System.out.println("Tytuł");
            String title = sc.nextLine();
            System.out.println("Wydwnictwo");
            String publisher = sc.nextLine();
            System.out.println("Język");
            String langaue = sc.nextLine();
            System.out.println("Rok Wydania");
            int year = getInt();
            System.out.println("<Miesiac");
            int month = sc.nextInt();
            System.out.println("Dzień");
            int day = getInt();

            return new Magazine ( title,publisher,langaue,year,month,day);
        }


    public void close(){
        sc.close();
    }
    public int getInt(){
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }
}
