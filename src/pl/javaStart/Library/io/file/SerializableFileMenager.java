package pl.javaStart.Library.io.file;

import pl.javaStart.Library.exeptions.DataExportExeption;
import pl.javaStart.Library.exeptions.DataImportExeption;
import pl.javaStart.Library.model.Library;

import java.io.*;

public class SerializableFileMenager implements Filemenager {
    private static final String FILE_NAME = " Library.o ";


    @Override
    public void exportData(Library library) {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(library);
        } catch (FileNotFoundException e) {
            throw new DataExportExeption("Brak pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new DataExportExeption("Bład zapisu danych do pliku " + FILE_NAME);
        }

    }

    @Override
    public Library importdata() {
        try (
                FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            return (Library) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportExeption("Brak pliku" + FILE_NAME);
        } catch (IOException e) {
            throw new DataImportExeption("Błąð odczytu" + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportExeption("Niezgodny typ danych w poliku" + FILE_NAME);
        }

    }
}
