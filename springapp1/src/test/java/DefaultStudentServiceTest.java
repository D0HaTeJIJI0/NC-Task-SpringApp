import com.netcracker.travnichev.config.StudentConfig;
import com.netcracker.travnichev.entity.Student;
import com.netcracker.travnichev.exception.StudentNotFoundException;
import com.netcracker.travnichev.service.StudentService;
import config.SpecializationServiceConfig;
import config.StudentServiceConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpecializationServiceConfig.class, StudentServiceConfig.class},
        loader = AnnotationConfigContextLoader.class)
class DefaultStudentServiceTest {

    @Autowired
    private StudentService studentService;
    private ApplicationContext studentContext;
    private Student student;

    @BeforeEach
    void init() {
        studentContext = new AnnotationConfigApplicationContext(StudentConfig.class);
        student = studentContext.getBean("student", Student.class);
    }

    @Test
    void addStudentShouldWorkOnValidData() {
        Student resultStudent = studentService.addStudent(student);
        assertEquals(resultStudent, student);
    }

    @Test
    void getStudentShouldWorkOnValidData() {
        Student result = studentService.addStudent(student);
        Long id = result.getId();
        try {
            Student resultStudent = studentService.getStudent(id);
            assertEquals(resultStudent.getId(), id);
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getStudentShouldThrowStudentNotFound() {
        Student result = studentService.addStudent(student);
        Long id = result.getId();
        Long newId;
        if (id < Long.MAX_VALUE) {
            newId = id + 1;
        }
        else {
            newId = id - 1;
        }
        assertThrows(StudentNotFoundException.class, () -> {studentService.getStudent(newId);});
    }

    @Test
    void deleteStudentByIdShouldWorkOnValidData() {
        Student result = studentService.addStudent(student);
        Student resultStudent = studentService.deleteStudentById(result.getId());
        assertEquals(resultStudent, student);
    }
}