package com.Vinith.JPAAndHibernate.LearnJPAandHibernate.course.JPA;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.Vinith.JPAAndHibernate.LearnJPAandHibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

	//@PersistenceContext  is same as Autowired
	@PersistenceContext 
	private EntityManager entityManager;
	
	public void insert(Course course)
	{
		entityManager.merge(course);
	}
	public void  delete(long id)
	{
		
		Course course=entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
	
	
	public Course findCourseById(long id)
	{
	   return entityManager.find(Course.class, id);
	}


	
	
}
