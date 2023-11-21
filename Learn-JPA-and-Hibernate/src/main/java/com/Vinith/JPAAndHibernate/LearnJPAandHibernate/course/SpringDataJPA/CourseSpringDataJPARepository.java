package com.Vinith.JPAAndHibernate.LearnJPAandHibernate.course.SpringDataJPA;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Vinith.JPAAndHibernate.LearnJPAandHibernate.course.Course;

public interface CourseSpringDataJPARepository extends JpaRepository<Course, Long> {

}
