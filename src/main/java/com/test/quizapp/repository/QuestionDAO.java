package com.test.quizapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.quizapp.entity.Question;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>{
	List<Question> findByCategory(String category);
	Optional<Question> findById(Integer id);
	
	@Query(value="select * from question q where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery  = true)
	List<Question> findRandomQuestionsByCategory(String category, int numQ);


}
