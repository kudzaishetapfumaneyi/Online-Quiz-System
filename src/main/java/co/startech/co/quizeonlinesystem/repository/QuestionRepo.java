package co.startech.co.quizeonlinesystem.repository;

import co.startech.co.quizeonlinesystem.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Integer> {
}
