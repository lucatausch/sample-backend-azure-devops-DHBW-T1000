package Praxis_I.studentsbackend.dao;

import Praxis_I.studentsbackend.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("mockedStudentDataAccessService")
public class StudentDataAccessService implements StudentDao {

    private static List<Student> database = new ArrayList<>();

    @Override
    public int insertNewStudent(UUID id, Student student) {
        database.add(new Student(id, student.getFirstName(), student.getLastName()));
        return 1;
    }

    @Override
    public List<Student> getStudentList() {
        return database;
    }

    @Override
    public Student getStudent(UUID studentId) {
        return database.stream()
                .filter(student -> studentId.equals(student.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Boolean updateStudent(Student updateStudent, UUID studentId) {
        Student oldStudent = database.stream()
                .filter(student -> studentId.equals(student.getId()))
                .findFirst()
                .orElse(null);

        if(null == oldStudent)
            return false;

        database.remove(oldStudent);
        insertNewStudent(studentId, updateStudent);

        return true;
    }


}
