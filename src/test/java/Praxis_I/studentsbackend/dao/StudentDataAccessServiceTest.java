package Praxis_I.studentsbackend.dao;

import Praxis_I.studentsbackend.model.Student;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class StudentDataAccessServiceTest {

    @Autowired
    private StudentDao studentDao;

    UUID studentId = UUID.randomUUID();
    Student student = new Student(null, "Max", "Mustermann");

    @Test
    void insertNewStudent() {
        assertThat(studentDao).isNotNull();

        int result = studentDao.insertNewStudent(studentId, student);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void getStudentList() {
        assertThat(studentDao).isNotNull();
        insertNewStudent();

        List<Student> students = studentDao.getStudentList();
        assertThat(students).isNotEmpty();
    }

    @Test
    void getStudent() {
        assertThat(studentDao).isNotNull();
        insertNewStudent();

        Student testStudent = studentDao.getStudent(studentId);

        assertThat(testStudent).isNotNull();
        assertThat(testStudent.getId()).isEqualTo(studentId);
        assertThat(testStudent.getFirstName()).isEqualTo(student.getFirstName());
        assertThat(testStudent.getLastName()).isEqualTo(student.getLastName());
    }

    @Test
    void updateStudent() {
        assertThat(studentDao).isNotNull();
        insertNewStudent();

        // in case the user exists
        Student newStudent = new Student(null, "Peter", "Müller");
        boolean result = studentDao.updateStudent(newStudent, studentId);

        assertThat(result).isTrue();

        Student testStudent = studentDao.getStudent(studentId);

        assertThat(testStudent).isNotNull();
        assertThat(testStudent.getId()).isEqualTo(studentId);
        assertThat(testStudent.getFirstName()).isEqualTo("Peter");
        assertThat(testStudent.getLastName()).isEqualTo("Müller");

        // in case the user does not exist
        boolean result2 = studentDao.updateStudent(newStudent, UUID.randomUUID());

        assertThat(result2).isFalse();
    }
}