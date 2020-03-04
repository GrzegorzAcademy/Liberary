package pl.javaStart.Library.app;

import pl.javaStart.Library.model.Book;

import java.util.Scanner;

public class DataReader {
    private Scanner sc = new Scanner(System.in);

    Book readAndCreateBook(){
        System.out.println("Tytuł");
        String title =  sc.nextLine();
        System.out.println("Author");
        String author = sc.nextLine();
        System.out.println("Wydawnictwo");
        String publisher = sc.nextLine();
        System.out.println("ISBN");
        String isbn = sc.nextLine();
        System.out.println("Rok Wydania");
        int relaseDate = sc.nextInt();
        sc.nextLine();
        System.out.println("Liczba stron");
        int pages = sc.nextInt();
        sc.nextLine();
      return   new Book(title,author,relaseDate,pages,publisher,isbn);
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
