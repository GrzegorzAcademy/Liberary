package pl.javaStart.Library.app;

import pl.javaStart.Library.model.Book;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        final String appName = "Biblioteka v0.8";
        Scanner sc = new Scanner(System.in);

        Book[] books = new Book[1000];
        DataReader dataReader = new DataReader();
        books[0] = dataReader.readAndCreateBook();
        books[1] =dataReader.readAndCreateBook();


dataReader.close();

        System.out.println(appName);
        System.out.println("Ksiązki w bibliotece");
        books[0].printInfo();
        books[1].printInfo();
    }
}
