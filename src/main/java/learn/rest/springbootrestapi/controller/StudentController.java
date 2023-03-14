package learn.rest.springbootrestapi.controller;

import learn.rest.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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
        students.add(new Student(3, "Jack", "Rose"));
        students.add(new Student(4, "Sathish", "Chaterjee"));
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

    // SprintBoot REST API that handles HTTP POST Request - creating new resource
    // Post Mapping and RequestBody
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //Spring boot REST API that hansdles HTTP PUT request - updating existing resource
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getId());
        System.out.println(student.getId());
        System.out.println(student.getId());
        return student;
    }

    //Springboot REST API that handles HTTP Delete request
    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return "Student deleted successfully";
    }
}