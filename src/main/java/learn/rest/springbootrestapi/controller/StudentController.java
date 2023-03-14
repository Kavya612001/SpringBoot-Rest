package learn.rest.springbootrestapi.controller;

import learn.rest.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(1, "Kavya", "Sampath Kumar");
        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Premalatha", "Chandran"));
        students.add(new Student(2, "John", "Doe"));
        students.add(new Student(3, "Rajesh", "Dayalan"));
        students.add(new Student(4, "Sathish", "Dayalan"));
        return students;
    }

    // Spring boot REST API with path variable
    // {id} - URI template variable
    // https://localhost:8080/students

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studenttId,
            @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName) {
        return new Student(studenttId, firstName, lastName);
    }

    // Spring boot REST API with Request param
    // http://localhost:8080/students/query?id=1&firstName=Kavya&lastName=Sampath
    @GetMapping("students/query")
    public Student studentRequesVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }
}
