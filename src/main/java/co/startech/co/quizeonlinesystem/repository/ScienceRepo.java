package co.startech.co.quizeonlinesystem.repository;

import co.startech.co.quizeonlinesystem.model.Science;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScienceRepo extends JpaRepository <Science, Long> {
}
