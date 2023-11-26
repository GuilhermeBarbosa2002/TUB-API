package ACSI.demo.REST.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student mariam = new Student("GUI",LocalDate.parse("2005-05-05"),"raul@gmail.Configuration");
            Student miguel = new Student("miguel",LocalDate.parse("2005-05-05"),"raul@gmail.Configuration");
            repository.saveAll(List.of(mariam, miguel));
        };
    }
}
