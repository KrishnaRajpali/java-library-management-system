import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class BookRepo {

    private final MongoClient mongoClient;
    private final MongoDatabase database;
    private final MongoCollection<Document> books;

    public BookRepo() {

        String connectionString = "mongodb://127.0.0.1:27017";

        mongoClient = MongoClients.create(connectionString);

        database = mongoClient.getDatabase("library_db");

        books = database.getCollection("books");

        // Test the connection
        database.runCommand(new Document("ping", 1));

        System.out.println("MongoDB connected successfully!");
    }

    public void addBook(Book book) {

        Document document = new Document()
                .append("author", book.getauthor())
                .append("genre", book.getgenre())
                .append("year", book.getyear())
                .append("price", book.getprice());

        books.insertOne(document);

        System.out.println("Book saved to MongoDB successfully!");
    }

    public void close() {
        mongoClient.close();
    }
}
