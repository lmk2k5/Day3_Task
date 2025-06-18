package studentmgmt;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;

public class EnrollmentManager {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("university");
        MongoCollection<Document> students = database.getCollection("students");
        MongoCollection<Document> courses = database.getCollection("courses");
        MongoCollection<Document> enrollments = database.getCollection("enrollments");
        System.out.println("Embedded Enrollments:");
        for (Document doc : enrollments.find(new Document("student", new Document("$exists", true)))) {
            Document student = (Document) doc.get("student");
            Document course = (Document) doc.get("course");

            System.out.println("Student: " + student.getString("name") + " | Course: " + course.getString("title"));
        }
        System.out.println("Referenced Enrollments:");
        for (Document doc : enrollments.find(new Document("studentId", new Document("$exists", true)))) {
            ObjectId studentId = doc.getObjectId("studentId");
            ObjectId courseId = doc.getObjectId("courseId");

            Document student = students.find(new Document("_id", studentId)).first();
            Document course = courses.find(new Document("_id", courseId)).first();
            if (student != null && course != null) {
                System.out.println("Student: " + student.getString("name") +
                        " | Course: " + course.getString("title"));
            }
        }

    }
}
