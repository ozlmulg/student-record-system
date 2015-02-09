package edu; /**
 * @author ozlem
 */

import edu.srs.config.StudentConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfiguration.class);

        SpringApplication.run(Application.class);

        /*
        StudentJDBCTemplate studentJDBCTemplate = context.getBean(StudentJDBCTemplate.class);

        System.out.println("------Add Student Records--------" );
        studentJDBCTemplate.addStudent("Özlem","Ulağ",1000,65);
        studentJDBCTemplate.addStudent("Dilek","Dündar",1001,85);
        studentJDBCTemplate.addStudent("Ebru","Acar",1002,75);
        studentJDBCTemplate.addStudent("Dilek","Sancak",1003,65);
        studentJDBCTemplate.addStudent("Tuğba","Gürbüz",1004,67);

        System.out.println("------Listing Multiple Records--------");
        List<Student> students = studentJDBCTemplate.listStudents();
        for (Student record : students) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.print(", Surname : " + record.getSurname());
            System.out.println(", Grade : " + record.getGrade());
        }

        System.out.println("----Updating Record with ID = 1000 -----" );
        studentJDBCTemplate.update(1000, 70);

        System.out.println("----Listing Record with ID = 1000 -----" );
        Student student = studentJDBCTemplate.getStudent(1000);
        System.out.print("ID : " + student.getId() );
        System.out.print(", Name : " + student.getName() );
        System.out.print(", Surname : " + student.getSurname());
        System.out.println(", Grade : " + student.getGrade());

        studentJDBCTemplate.delete(1004);

        System.out.println("------Listing Multiple Records--------");
        students = studentJDBCTemplate.listStudents();
        for (Student record : students) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.print(", Surname : " + record.getSurname());
            System.out.println(", Grade : " + record.getGrade());
        }
        */

    }
}