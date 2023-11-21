package com.Vinith.JPAAndHibernate.LearnJPAandHibernate.course.Jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Vinith.JPAAndHibernate.LearnJPAandHibernate.course.Course;

@Repository
@ComponentScan
public class CourseJDBCRepository {
     
	@Autowired
	private JdbcTemplate JdbcTemplate;
	String insertQuery= """
			
			insert into course(id,name , author) values(?,?,?);
			
			""";
	
	String deleteQuery="""
			delete from course where id=?;
			""";
	
	String selectQuery="""
			select * from course where id=?;
			""";
	
	public void insert(Course course)
	{
		
		JdbcTemplate.update(insertQuery,course.getId(),course.getName(),course.getAuthor());
	}
	public void  delete(long id)
	{
		
		JdbcTemplate.update(deleteQuery,id);
	}
	
	
	public Course findCourseById(long id)
	{
		return JdbcTemplate.queryForObject(selectQuery, new BeanPropertyRowMapper<>(Course.class),id);
	}

}
