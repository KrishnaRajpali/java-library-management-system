public class Book {
    String author;
    String genre;
    int year;
    double price;
    static int count=0;

    Book(String author, String genre, int year, double price){
        this.author=author;
        this.genre=genre;
        this.year=year;
        this.price=price;

        count++;
    }
    static int getCount(){
        System.out.println("The total count is: "+count);
        return count;
    }

    public String getauthor() {
        return author;
    }

    public String getgenre() {
        return genre;
    }

    public int getyear() {
        return year;
    }

    public double getprice() {
        return price;
    }

    void information(){
        System.out.println("\n");
        System.out.println("The book was written by: "+ this.author);
        System.out.println("The book's genre is: "+ this.genre);
        System.out.println("The book was published in the year: "+ this.year);
        System.out.println("The price of the book is: $"+ this.price);
        System.out.println("\n");
    }
}
