package pl.javaStart.Library.app;

import javax.crypto.spec.OAEPParameterSpec;

public enum Option {
    EXIT(0,"Wyjście z programu"),
    ADD_BOOK(1,"Dodanie nowej książki"),
    PRINT_BOOKS(2,"Dostępne książki"),
    ADD_MAGAZINES (3,"Dodanie magazynu"),
    PRINT_MAGAZINES(4,"Wyswietl dostępne magazyny");
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
        return value + " - " + description ;
    }
    static Option createFromInt(int option) throws NoSuchFieldException {
        try{
           return Option.values()[option];
    }catch (ArrayIndexOutOfBoundsException e){
    throw new NoSuchFieldException("no option with id" + option);


    }
}
}
