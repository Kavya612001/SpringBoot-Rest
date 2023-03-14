package learn.rest.springbootrestapi.controller;

import learn.rest.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.Response;

@RestController
@RequestMapping("students")
public class StudentController {

    //http://localhost:8080/students/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Kavya", "Sampath Kumar");
        //return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok().header("custom-header", "Rajesh").body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Premalatha", "Chandran"));
        students.add(new Student(2, "John", "Doe"));
        students.add(new Student(3, "Jack", "Rose"));
        students.add(new Student(4, "Sathish", "Chaterjee"));
        return ResponseEntity.ok(students);
    }

    // Spring boot REST API with path variable
    // {id} - URI template variable
    // https://localhost:8080/students

    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studenttId,
            @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName) {
        Student student  = new Student(studenttId, firstName, lastName);
        return ResponseEntity.ok(student);

    }

    // Spring boot REST API with Request param
    // http://localhost:8080/students/query?id=1&firstName=Kavya&lastName=Sampath
    @GetMapping("query")
    public ResponseEntity<Student> studentRequesVariable(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);
        return ResponseEntity.ok(student);
    }

    // SprintBoot REST API that handles HTTP POST Request - creating new resource
    // Post Mapping and RequestBody
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    //Spring boot REST API that hansdles HTTP PUT request - updating existing resource
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getId());
        System.out.println(student.getId());
        System.out.println(student.getId());
        return ResponseEntity.ok(student);
    }

    //Springboot REST API that handles HTTP Delete request
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        System.out.println(studentId);
        return ResponseEntity.ok("Student deleted successfully");
    }
}