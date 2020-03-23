package pl.javaStart.Library.io.file;

import pl.javaStart.Library.exeptions.DataExportExeption;
import pl.javaStart.Library.exeptions.DataImportExeption;
import pl.javaStart.Library.exeptions.InvalidDataExeption;
import pl.javaStart.Library.model.Book;
import pl.javaStart.Library.model.Library;
import pl.javaStart.Library.model.Magazine;
import pl.javaStart.Library.model.Publication;

import java.io.*;
import java.util.Scanner;

public class CsvFileManager implements Filemenager {
    private static final String FILE_NAME = "Library.csv";

    @Override
    public void exportData(Library library) {
        Publication[] publications = library.getPublications();
        try (FileWriter fileWriter = new FileWriter(FILE_NAME);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Publication publication : publications) {
                bufferedWriter.write(publication.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportExeption("Błąd zapisu do pliku " + FILE_NAME);
        }
    }

    @Override
    public Library importdata() {
        Library library = new Library();
        try (
                Scanner fileReader = new Scanner(new File(FILE_NAME))
        ) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                Publication publication = createObjectFromString(line);
                library.addPublication(publication);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportExeption("Brak pliku " + FILE_NAME);
        }
        return library;
    }

    private Publication createObjectFromString(String csvText) {
        String[] split = csvText.split(";");
        String type = split[0];
        if (Book.TYPE.equals(type)) {
            return createBook(split);
        } else if (Magazine.TYPE.equals(type)) {
            return createMagazine(split);
        }

        throw new InvalidDataExeption("Nieznany typ publikacji " + type);
    }

    private Book createBook(String[] data) {
        String title = data[1];
        String publisher = data[2];
        int year = Integer.valueOf(data[3]);
        String author = data[4];
        int pages = Integer.valueOf(data[5]);
        String isbn = data[6];
        return new Book(title, author, year, pages, publisher, isbn);
    }

    private Magazine createMagazine(String[] data) {
        String title = data[1];
        String publisher = data[2];
        String langaue = data[3];
        int day = Integer.valueOf(data[4]);
        int year = Integer.valueOf(data[5]);
        int month = Integer.valueOf(data[6]);

        return new Magazine(title, publisher, langaue, year, month, day);
    }
}
