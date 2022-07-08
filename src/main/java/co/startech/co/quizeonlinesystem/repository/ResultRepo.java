package co.startech.co.quizeonlinesystem.repository;

import co.startech.co.quizeonlinesystem.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepo extends JpaRepository<Result, Integer> {

}
