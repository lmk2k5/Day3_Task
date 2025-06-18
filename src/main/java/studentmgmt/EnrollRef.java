package studentmgmt;

import org.bson.Document;
import org.bson.types.ObjectId;

public class EnrollRef {
    public static Document create(ObjectId studentId, ObjectId courseId) {
        return new Document("studentId", studentId).append("courseId", courseId);
    }
}
