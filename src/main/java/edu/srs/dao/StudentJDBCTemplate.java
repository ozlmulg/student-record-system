package edu.srs.dao;
/**
 * @author ozlem
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private final static Logger logger = LoggerFactory.getLogger(StudentJDBCTemplate.class);

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public void addStudent(String name, String surname, Integer id, Integer grade) {
        String SQL = "insert into Student (id,name, surname,grade) values (?, ?, ?, ?)";

        jdbcTemplateObject.update( SQL,id, name, surname,grade);
        logger.info("Added Student Record: Id = " + id + " Name = " + name + " Surname = " + surname + " Grade = " + grade);
        return;
    }

    public Student getStudent(Integer id) {
        String SQL = "select * from Student where id = ?";
        Student student = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new StudentMapper());
        return student;
    }

    public List<Student> listStudents() {
        String SQL = "select * from Student";
        List <Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
        return students;
    }

    public void delete(Integer id){
        String SQL = "delete from Student where id = ?";
        jdbcTemplateObject.update(SQL, id);
        logger.info("Deleted Student Record with ID = " + id);
        return;
    }

    @Override
    public void update(Integer id, Integer grade) {
        String SQL = "update Student set grade = ? where id = ?";
        jdbcTemplateObject.update(SQL, grade, id);
        logger.info("Updated Student Record with ID = " + id );
        return;
    }


}