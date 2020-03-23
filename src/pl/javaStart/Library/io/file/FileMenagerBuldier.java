package pl.javaStart.Library.io.file;

import pl.javaStart.Library.exeptions.NoSuchFileTypeExeption;
import pl.javaStart.Library.io.ConsolePrinter;
import pl.javaStart.Library.io.DataReader;

public class FileMenagerBuldier {
    private ConsolePrinter printer;
    private DataReader dataReader;

    public FileMenagerBuldier(ConsolePrinter printer, DataReader dataReader) {
        this.printer = printer;
        this.dataReader = dataReader;
    }

    public Filemenager bulid() {
        System.out.println("Wybierz format danych ");
        FileType fileType = getfiletype();
        switch (fileType){
            case SERIAL:
                return new SerializableFileMenager();
            case CSV:
              return new CsvFileManager();
            default:
                throw new NoSuchFileTypeExeption("Nie obsługiwany format danych ");
        }
    }

    private FileType getfiletype() {
        boolean typeOK = false;
        FileType result = null;
        do {
            printTypes();
            String type = dataReader.getString().toUpperCase();
            try {
                result = FileType.valueOf(type);
                typeOK = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Nieobsługiwany typ danych ");
            }
        } while (!typeOK);
        return result;

    }

    private void printTypes() {
        for (FileType value : FileType.values()) {
            printer.printLine(value.name());
        }
    }
}
