package studentmgmt;

import org.bson.Document;

public class EnrollEmb {
    public static Document create(Student student, Course course) {
        return new Document("student", new Document("name", student.name).append("age", student.age))
                .append("course", new Document("title", course.title).append("code", course.code));
    }
}
