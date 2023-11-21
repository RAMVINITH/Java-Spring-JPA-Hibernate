package com.Vinith.JPAAndHibernate.LearnJPAandHibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.Vinith.JPAAndHibernate.LearnJPAandHibernate.course.Course;
import com.Vinith.JPAAndHibernate.LearnJPAandHibernate.course.JPA.CourseJpaRepository;
import com.Vinith.JPAAndHibernate.LearnJPAandHibernate.course.Jdbc.CourseJDBCRepository;
import com.Vinith.JPAAndHibernate.LearnJPAandHibernate.course.SpringDataJPA.CourseSpringDataJPARepository;


@Component
public class CourseCommandLineRunner implements CommandLineRunner{
	
//	@Autowired
//	private CourseJDBCRepository repository;

//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJPARepository repositoryjpa;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		repository.insert(new Course(1,"learn Spring","Vinth"));
//		repository.insert(new Course(2,"learn AWS","Vinth"));
//		repository.insert(new Course(3,"learn Azure","Vinth"));
//		repository.delete(3);
//		
//		System.out.println(repository.findCourseById(2));
//		System.out.println(repository.findCourseById(1));
		
		
		// this is for Spring Data JPA
		//here we should use save(inbuild method) instead of insert
		repositoryjpa.save(new Course(1,"learn Spring","Vinth"));
		repositoryjpa.save(new Course(2,"learn AWS","Vinth"));
		repositoryjpa.save(new Course(3,"learn Azure","Vinth"));
		//we have to mention id with postfix as l in Spring jpa. 
		repositoryjpa.deleteById(3l);
		
		System.out.println(repositoryjpa.findById(2l));
		System.out.println(repositoryjpa.findById(1l));
	
		
	}
	
	
	

}
