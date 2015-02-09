package edu.srs.web.controller;

import edu.srs.dao.Student;
import edu.srs.dao.StudentJDBCTemplate;
import edu.srs.config.StudentConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ozlem
 */
@Controller
public class StudentController extends WebMvcConfigurerAdapter {
    @Autowired
    StudentJDBCTemplate template;

    @RequestMapping(value = "/addStudent",method = RequestMethod.GET)
    public String addStudentView(Model model){//USAGE= http://localhost:8080/addStudents
        model.addAttribute("student",new Student());
        return "addStudent";
    }

    @RequestMapping(value = "/info",method = RequestMethod.POST)
    public String addStudentInfo(@Valid Student student, BindingResult bindingResult,Model model){

        if(bindingResult.hasErrors())
            return "addStudent";

        try {
            ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfiguration.class);
            StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
            studentJDBCTemplate.addStudent(student.getName(), student.getSurname(), student.getId(), student.getGrade());

            model.addAttribute("message", "The student record is successfully added.");
        }catch (Exception ex){
            model.addAttribute("message","There is already a student with id="+student.getId());
        }
        return "info";
    }

    @RequestMapping("/student") //USAGE= http://localhost:8080/student?id=1000
    public String getStudentView(@RequestParam(value="id", required=true) String id,
                           Model model){
        ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfiguration.class);
        StudentJDBCTemplate studentJDBCTemplate = context.getBean(StudentJDBCTemplate.class);
        try{
            Student student = studentJDBCTemplate.getStudent(Integer.parseInt(id));
            model.addAttribute("name",student.getName());
            model.addAttribute("surname",student.getSurname());
            model.addAttribute("id",student.getId());
            model.addAttribute("grade",student.getGrade());
            return "getStudent";
        }catch (Exception ex){
            model.addAttribute("message","No such student found with id="+id);
            return "info";
        }

    }

    @RequestMapping("/listStudents") //USAGE= http://localhost:8080/listStudents
    public String listStudentsView(Model model){
        ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfiguration.class);
        StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
        List<Student> students = studentJDBCTemplate.listStudents();

        model.addAttribute("students",students);
        return "listStudents";
    }



    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public ModelAndView welcomePage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is welcome page!");
        model.setViewName("hello");
        return model;

    }

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is protected page - Admin Page!");
        model.setViewName("admin");

        return model;

    }

    @RequestMapping(value = "/dba**", method = RequestMethod.GET)
    public ModelAndView dbaPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Hello World");
        model.addObject("message", "This is protected page - Database Page!");
        model.setViewName("admin");

        return model;

    }
}
