package ACSI.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("email taken!");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {

        Boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("student doesn't exist!");
        }
        studentRepository.deleteById(id);
    }
@Transactional
    public void updateStudent(Long id, Student student) {

        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student not found"));

       // LocalDate localDate = studentRepository.getDobById(id);

        LocalDate localDate = existingStudent.getDob();

        System.out.println(localDate);
        if (!localDate.equals(student.getDob())) {
            throw new IllegalStateException("You can't change your birthday!!");
        }

        existingStudent.setEmail(student.getEmail());
        existingStudent.setName(student.getName());

        System.out.printf("ALTEREI");


    }
}
