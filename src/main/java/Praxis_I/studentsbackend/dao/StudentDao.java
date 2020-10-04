package Praxis_I.studentsbackend.dao;

import Praxis_I.studentsbackend.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDao {
    int insertNewStudent(UUID id, Student student);

    default int insertNewStudent(Student student) {
        UUID id = UUID.randomUUID();
        return insertNewStudent(id, student);
    }

    List<Student> getStudentList();

    Student getStudent(UUID studentId);

    Boolean updateStudent(Student updateStudent, UUID studentId);
}
