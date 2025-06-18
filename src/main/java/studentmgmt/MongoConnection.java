package studentmgmt;
import com.mongodb.client.*;

public class MongoConnection {
    public static MongoDatabase getDatabase() {
        MongoClient client = MongoClients.create("mongodb://localhost:27017");
        return client.getDatabase("studentmgmt");

    }
}
