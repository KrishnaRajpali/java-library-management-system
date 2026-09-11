import java.util.*;

public class LibManage {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BookRepo repository=new BookRepo();

        System.out.println("**********************");
        System.out.println("WELCOME TO THE LIBRARY");
        System.out.println("**********************\n");
        String choice;

        do {
            System.out.print("Enter the name of the author: ");
            String author=sc.nextLine();

            System.out.print("Enter genre: ");
            String genre=sc.nextLine();

            System.out.print("Enter year of publication: ");
            int year=sc.nextInt();

            System.out.print("Enter price of the book: ");
            double price=sc.nextDouble();

            Book book=new Book(author, genre, year, price);
            repository.addBook(book);

            book.information();

            System.out.print("Do you want another book: ");
            choice=sc.next();

            sc.nextLine(); //consumes extra line
        }while(choice.equalsIgnoreCase("yes"));

        Book.getCount();

        repository.close();
        sc.close();
    }
}