package co.develhope.Angelo.ServiziEmail01.user.services;

import co.develhope.Angelo.ServiziEmail01.user.entities.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//defines a StudentService
@Service
public class StudentService {

    //a list of 4 Students, where the first one is you
    static List<Student> students = Arrays.asList(
            new Student("1","Angelo","Zammataro","angelo.zammataro76@gmail.com"),
            new Student("2","Carlo","Martello","ilmartellodifranciasonoio@gmail.com"),
            new Student("3","Giulio","Cesare","imperatoresenzacorona@gmail.com"),
            new Student("4","Giovanna","D'Arco","lapulzelladorleans@gmail.com")
    );

    //a method getStudentById that returns the Student if it's present in the list
    public Student getStudentById(String sudentId) {
        Optional<Student> studentFromDb = students.stream().filter(student -> student.getId().equals(sudentId)).findAny();
        if (studentFromDb.isPresent()) return studentFromDb.get();
        return null;
    }
}
