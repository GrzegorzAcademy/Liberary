public class Book {
    String title ;
    String author ;
    int relaseDate ;
    int pages;
    String publisher;
    String isbn ;

    public Book(String Booktitle, String  Bookauthor, int  BookrelaseDate,
                int  Bookpages, String  Bookpublisher, String  Bookisbn) {
        this.title =  Booktitle;
        this.author =  Bookauthor;
        this.relaseDate = BookrelaseDate;
        this.pages =  Bookpages;
        this.publisher =  Bookpublisher;
        this.isbn =  Bookisbn;
    }

    void printInfo() {
        String info = title+" "+ author+ " "+ relaseDate+ " "+ pages + " "+ publisher +" "+ isbn;
        System.out.println(info);
    }
}
