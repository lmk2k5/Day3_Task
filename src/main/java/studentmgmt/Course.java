package studentmgmt;
import org.bson.Document;

public class Course {
    public String title;
    public String code;

    public Course(String title, String code) {
        this.title = title;
        this.code = code;
    }

    public Document toDocument() {
        return new Document("title", title).append("code", code);
    }
}
