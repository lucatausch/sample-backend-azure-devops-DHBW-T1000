package Praxis_I.studentsbackend.service;

import Praxis_I.studentsbackend.dao.StudentDao;
import Praxis_I.studentsbackend.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("mockedStudentDataAccessService") StudentDao _studentDao) {
        studentDao = _studentDao;
    }

    public int insertStudent(Student student) {
        return studentDao.insertNewStudent(student);
    }

    public int insertStudent(UUID studentId, Student student)
    {
        return studentDao.insertNewStudent(studentId, student);
    }

    public List<Student> getStudentList(){
        return studentDao.getStudentList();
    }

    public Student getStudentById(UUID id) {
        return studentDao.getStudent(id);
    }

    public Boolean updateStudent(Student updateStudent, UUID studentId) {
        return studentDao.updateStudent(updateStudent, studentId);
    }
}
