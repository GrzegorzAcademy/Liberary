public class Book {
    String title ;
    String author ;
    int relaseDate ;
    int pages;
    String publisher;
    String isbn ;

    public Book(String title, String author, int relaseDate, int pages, String publisher) {
        this.title = title;
        this.author = author;
        this.relaseDate = relaseDate;
        this.pages = pages;
        this.publisher = publisher;
    }

    public Book(String title, String author, int relaseDate, int pages, String publisher, String isbn) {
        this(title,author,relaseDate,pages,publisher);
        this.isbn = isbn;
    }


    void printInfo() {
        String info = title+" "+ author+ " "+ relaseDate+ " "+ pages + " "+ publisher +" "+ isbn;
        System.out.println(info);
    }
}
